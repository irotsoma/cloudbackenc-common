/*
 * Copyright (C) 2016-2017  Irotsoma, LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.irotsoma.cloudbackenc.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import mu.KLogging

import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.util.*
import java.util.jar.JarFile
import kotlin.reflect.KClass

/**
 * Created by irotsoma on 12/19/2017.
 *
 * Imports and stores information about installed Encryption Service Extensions
 */


abstract class ExtensionRepository{
    /** kotlin-logging implementation*/
    companion object: KLogging()
    var extensions = emptyMap<UUID,Extension<ExtensionFactory>>()
    abstract var extensionSettings: ExtensionSettings
    abstract var parentClassLoader: ClassLoader

    /**
     * Generates an Extension Config object.
     *
     * Override this if using a customized extension configuration file format
     */
    fun createExtensionConfig(jsonConfig: String) : ExtensionConfig {
        return ObjectMapper().registerModule(KotlinModule()).readValue(jsonConfig)
    }



    inline fun <reified T: ExtensionFactory> loadDynamicServices() {
        if (parentClassLoader==null){
            throw NullPointerException("The value of parentClassLoader must be set before calling loadDynamicServices().")
        }
        //external config extension directory
        val extensionsDirectory: File? = File(extensionSettings?.directory)
        //internal resources extension directory (packaged extensions or test extensions)
        val resourcesExtensionsDirectory: File? =
            try{
                File(javaClass.classLoader.getResource("extensions")?.file)
            } catch (ignore: NullPointerException) { null }
        if ((extensionsDirectory?.isDirectory != true || !extensionsDirectory.canRead()) && ((resourcesExtensionsDirectory?.isDirectory != true || !(resourcesExtensionsDirectory.canRead())))) {
            logger.warn{"Extensions directory is missing or unreadable."}
            logger.debug{"Config directory: ${extensionsDirectory?.absolutePath}"}
            logger.debug{"Resource directory: ${resourcesExtensionsDirectory?.absolutePath}"}
            return
        }
        logger.trace{"Config extension directory:  ${extensionsDirectory?.absolutePath}"}
        logger.trace{"Resources extension directory:  ${resourcesExtensionsDirectory?.absolutePath}"}
        val jarURLs = hashMapOf<UUID,URL>()
        val extensionConfigs = hashMapOf<UUID,ExtensionConfig>()
        for (jar in (extensionsDirectory?.listFiles{directory, name -> (!File(directory,name).isDirectory && name.endsWith(".jar"))} ?: arrayOf<File>()).plus(resourcesExtensionsDirectory?.listFiles{directory, name -> (!File(directory,name).isDirectory && name.endsWith(".jar"))} ?: arrayOf<File>())) {
            try {
                val jarFile = JarFile(jar)
                //read config file from jar if present
                val jarFileEntry = jarFile.getEntry(extensionSettings?.configFileName)
                if (jarFileEntry == null) {
                    logger.warn{"Extension file missing config file named ${extensionSettings?.configFileName}. Skipping jar file: ${jar.absolutePath}"}
                }
                else {
                    //get Json config file data
                    val jsonValues = jarFile.getInputStream(jarFileEntry).reader().readText()
                    val config = createExtensionConfig(jsonValues)
                    val encryptionServiceUUID = UUID.fromString(config.serviceUuid)
                    //add values to maps for consumption later
                    if (extensionConfigs.containsKey(encryptionServiceUUID)){
                        //if the UUID is already in the map check to see if it's a newer version.  If so replace, the existing one, otherwise ignore the new one.
                        if (extensionConfigs[encryptionServiceUUID]!!.releaseVersion < config.releaseVersion){
                            extensionConfigs.replace(encryptionServiceUUID, config)
                            jarURLs.replace(encryptionServiceUUID,jar.toURI().toURL())
                        }
                    } else {
                        //if the UUID is not in the map add it
                        extensionConfigs.put(encryptionServiceUUID, config)
                        jarURLs.put(encryptionServiceUUID,jar.toURI().toURL())
                    }
                }
            }  catch (e: Exception) {
                logger.warn{"Error processing encryption service extension file. This extension will be unavailable: ${jar.name}.   Error Message: ${e.message}"}
            }
        }
        val classLoader: URLClassLoader? = URLClassLoader(jarURLs.values.toTypedArray(), parentClassLoader)
        if (classLoader == null){
            logger.error { "Unable to create a classloader to load extensions!" }
            return
        }
        //cycle through all of the classes, make sure they inheritors EncryptionServiceFactory, and add them to the list
        for ((key, value) in extensionConfigs) {
            try{
                val gdClass = classLoader.loadClass("${value.packageName}.${value.factoryClass}")
                //verify instance of gdClass is a EncryptionServiceFactory
                if (gdClass.newInstance() is T) {
                    val extension = value.generateExtension(gdClass as KClass<ExtensionFactory>)
                    extensions = extensions.plus(Pair(key,extension))
                }
                else {
                    logger.warn{"Error loading encryption service extension: Factory is not an instance of EncryptionServiceFactory: $value" }
                }
            } catch(e: ClassNotFoundException){
                logger.warn{"Error loading encryption service extension: $value: ${e.message}"}
            }
        }

    }
}

