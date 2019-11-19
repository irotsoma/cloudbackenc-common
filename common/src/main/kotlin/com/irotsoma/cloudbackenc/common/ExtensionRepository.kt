/*
 * Copyright (C) 2016-2019  Irotsoma, LLC
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
import mu.KotlinLogging
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.util.*
import java.util.jar.JarFile

/**
 * Imports and stores information about installed Encryption Service Extensions
 *
 * @author Justin Zak
 * @property extensions A HashMap of the ExtensionFactory implementation with the extension's UUID as key
 * @property extensionConfigs A HashMap of the Extension implementation which contains metadata from the extension's json configuration with the extension's UUID as the key
 * @property extensionSettings An ExtensionSettings object that contains information about the implementing class's extensions in general
 * @property parentClassLoader A ClassLoader that is to be used to load the extensions
 */

//TODO: refactor to register threads using these classes and allow for reloading them when the jar files change

abstract class ExtensionRepository{
    /** kotlin-logging implementation*/
    private companion object: KLogging()
    var extensions = hashMapOf<UUID,Class<out ExtensionFactory>>()
    var extensionConfigs = hashMapOf<UUID, Extension>()
    var extensionSettings: ExtensionSettings? = null
    var parentClassLoader: ClassLoader? = null
    /**
     * Must be called by the implementing class to load the extensions.
     */
    inline fun <reified F:ExtensionFactory, reified C: Extension> loadDynamicServices() {
        val logger = KotlinLogging.logger {}
        if (parentClassLoader==null){
            throw NullPointerException("The value of parentClassLoader must be set before calling loadDynamicServices().")
        }
        //external config extension directory
        val extensionsDirectory: File? =
            try {
                File(extensionSettings?.directory!!)
            } catch (ignore: NullPointerException) { null }
        //internal resources extension directory (packaged extensions or test extensions)
        val resourcesExtensionsDirectory: File? =
            try{
                File(javaClass.classLoader.getResource("extensions")?.file!!)
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
        for (jar in (extensionsDirectory?.listFiles{directory, name -> (!File(directory,name).isDirectory && name.endsWith(".jar"))} ?: arrayOf<File>()).plus(resourcesExtensionsDirectory?.listFiles{directory, name -> (!File(directory,name).isDirectory && name.endsWith(".jar"))} ?: arrayOf<File>())) {
            try {
                val jarFile = JarFile(jar)
                //read config file from jar if present
                val jarFileEntry = jarFile.getEntry(extensionSettings?.configFileName)
                if (jarFileEntry == null) {
                    logger.debug{"Extension file missing config file named ${extensionSettings?.configFileName}. Skipping jar file: ${jar.absolutePath}"}
                } else {
                    //get Json config file data
                    val jsonValues = jarFile.getInputStream(jarFileEntry).reader().readText()
                    val config: C = ObjectMapper().registerModule(KotlinModule()).readValue(jsonValues)
                    val extensionUUID = UUID.fromString(config.extensionUuid)
                    //add values to maps for consumption later
                    if (extensionConfigs.containsKey(extensionUUID)){
                        //if the UUID is already in the map check to see if it's a newer version.  If so replace, the existing one, otherwise ignore the new one.
                        if (extensionConfigs[extensionUUID]!!.releaseVersion < config.releaseVersion){
                            extensionConfigs.replace(extensionUUID, config)
                            jarURLs.replace(extensionUUID,jar.toURI().toURL())
                        }
                    } else {
                        //if the UUID is not in the map add it
                        extensionConfigs[extensionUUID] = config
                        jarURLs[extensionUUID] = jar.toURI().toURL()
                    }
                }
            }  catch (e: Exception) {
                logger.warn{"Error processing extension file. This extension will be unavailable: ${jar.name}.   Error Message: ${e.message}"}
            }
        }
        val classLoader: URLClassLoader? = URLClassLoader(jarURLs.values.toTypedArray(), parentClassLoader)
        if (classLoader == null){
            logger.error { "Unable to create a classloader to load extensions!" }
            return
        }
        //cycle through all of the classes, make sure they inherit an ExtensionFactory, and add them to the list
        for ((key, value) in extensionConfigs) {
            try{
                val gdClass = classLoader.loadClass("${value.packageName}.${value.factoryClass}")
                //verify instance of gdClass is an ExtensionFactory
                if (gdClass.getDeclaredConstructor().newInstance() is F) {
                    @Suppress("UNCHECKED_CAST") //we've already checked that the class is F in the above if statement, so unchecked cast can be ignored
                    extensions[key] = gdClass as Class<F>
                }
                else {
                    logger.warn{"Error loading extension: Factory is not an instance of ${F::class.simpleName}: $value" }
                }
            } catch(e: ClassNotFoundException){
                logger.warn{"Error loading extension: $value: ${e.message}"}
            }
        }

    }
}

