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
 * Created by irotsoma on 8/18/2016.
 */
package com.irotsoma.cloudbackenc.common.encryption

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.irotsoma.cloudbackenc.common.ExtensionFactory
import java.util.*

/**
 * Encryption Service Factory interface
 *
 * @author Justin Zak
 */
abstract class EncryptionFactory : ExtensionFactory {
    /** Companion object to hold the static class constants */
    companion object {
        /** The name of the resource file that contains the extension configuration */
        private const val EXTENSION_CONFIG_FILE_PATH = "encryption-extension.json"
        /** UID for this class for java's Serializable object */
        const val serialVersionUID = 91514875
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
     * Reads the config file to get the UUID and Name of the current extension.
     */
    init {
        //get Json config file data
        val configFileStream = this::class.java.classLoader.getResourceAsStream(EXTENSION_CONFIG_FILE_PATH)
        val jsonValue = configFileStream.reader().readText()
        val mapper = ObjectMapper().registerModule(KotlinModule())
        val mapperData: EncryptionExtension = mapper.readValue(jsonValue)
        //add values to variables for consumption later
        extensionUuid = UUID.fromString(mapperData.extensionUuid)
        extensionName = mapperData.extensionName
        extensionVersion = mapperData.releaseVersion
    }
    /**
     * List of key algorithms that the extension supports
     *
     * EncryptionSymmetricKeyAlgorithms for list of possible values
     */
    abstract val supportedSymmetricKeyAlgorithms: Array<EncryptionSymmetricKeyAlgorithms>
    /**
     * List of encryption algorithms that the extension supports
     *
     * EncryptionSymmetricEncryptionAlgorithms for list of possible values
     */
    abstract val supportedSymmetricEncryptionAlgorithms: Array<EncryptionSymmetricEncryptionAlgorithms>
    /**
     * List of key algorithms that the extension supports
     *
     * EncryptionSymmetricKeyAlgorithms for list of possible values
     */
    abstract val supportedAsymmetricKeyAlgorithms: Array<EncryptionAsymmetricKeyAlgorithms>
    /**
     * List of encryption algorithms that the extension supports
     *
     * EncryptionSymmetricEncryptionAlgorithms for list of possible values
     */
    abstract val supportedAsymmetricEncryptionAlgorithms: Array<EncryptionAsymmetricEncryptionAlgorithms>
    /**
     * List of PBKDF Algorithms that the extension supports
     *
     * EncryptionPBKDFEncryptionAlgorithms for list of possible values
     */
    abstract val supportedPBKDFEncryptionAlgorithms: Array<EncryptionPBKDFEncryptionAlgorithms>
    /**
     * Service that handles generation and processing of encryption keys
     */
    abstract val encryptionKeyService: EncryptionKeyService
    /**
     * Service that handles encryption and decryption of data streams
     */
    abstract val encryptionStreamService: EncryptionStreamService
    /**
     * Service that handles encryption and decryption of strings
     */
    abstract val encryptionStringService: EncryptionStringService

    /**
     * Determines if two instances of CloudServiceFactory are equal by comparing the uuid and name.  Both must be the
     * same.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is EncryptionFactory){
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