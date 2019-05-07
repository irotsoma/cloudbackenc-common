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
/*
 * Created by irotsoma on 6/20/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservices

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.irotsoma.cloudbackenc.common.ExtensionFactory
import java.io.Serializable
import java.util.*

/**
 * Cloud Service Factory interface
 *
 * @author Justin Zak
 */
abstract class CloudServiceFactory: ExtensionFactory, Serializable
{
    /** Companion Object to hold the serialVersionUID and config file name */
    companion object {
        /** The name of the resource file that contains the extension configuration */
        const val EXTENSION_CONFIG_FILE_PATH = "cloud-service-extension.json"
        /** UID for this class for java's Serializable object */
        const val serialVersionUID = 84685165165
    }
    /**
     * Contains the extension UUID pulled from the config json file
     */
    final override val extensionUuid: UUID
    /**
     * Contains the extension name pulled from the config json file
     */
    final override val extensionName: String
    /**
     * Contains the version of the extension pulled from the config json file
     */
    final override val extensionVersion: Int

    /**
     * Flag to specify that the client must supply a username
     */
    val requiresUsername: Boolean
    /**
     * Flag to specify that the client must supply a password
     */
    val requiresPassword: Boolean
    /**
     * Token for the application to access the cloud service provider (if needed to be stored by client rather than
     * server).
     */
    var token: String? = null
    /**
     * Stores any custom settings needed for a cloud service extension
     */
    val additionalSettings = HashMap<String, String>()

    /**
     * Reads the config file to get the UUID and Name of the current extension.
     */
    init {
        //get Json config file data
        val configFileStream = this::class.java.classLoader.getResourceAsStream(EXTENSION_CONFIG_FILE_PATH)
        val jsonValue = configFileStream.reader().readText()
        val mapper = ObjectMapper().registerModule(KotlinModule())
        val mapperData: CloudServiceExtension = mapper.readValue(jsonValue)
        //add values to variables for consumption later
        extensionUuid = UUID.fromString(mapperData.extensionUuid)
        extensionName = mapperData.extensionName
        extensionVersion = mapperData.releaseVersion
        requiresUsername = mapperData.requiresUsername
        requiresPassword = mapperData.requiresPassword
        additionalSettings.putAll(mapperData.additionalSettings)
    }
    /**
     * Instance of CloudServiceAuthenticationService for the cloud service implementation.
     */
    abstract val authenticationService: CloudServiceAuthenticationService
    /**
     * Instance of CloudServiceFileIOService for the cloud service implementation.
     */
    abstract val cloudServiceFileIOService: CloudServiceFileIOService

    /**
     * Determines if two instances of CloudServiceFactory are equal by comparing the uuid and name.  Both must be the
     * same.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is CloudServiceFactory){
            false
        } else {
            (other.extensionUuid == this.extensionUuid) && (other.extensionName == this.extensionName) && (other.extensionVersion == this.extensionVersion)
        }
    }

    /**
     * Generates a hash code based on the UUID, name, and version.
     */
    override fun hashCode(): Int {
        return extensionUuid.hashCode() + extensionName.hashCode() + extensionVersion.hashCode()
    }
}

