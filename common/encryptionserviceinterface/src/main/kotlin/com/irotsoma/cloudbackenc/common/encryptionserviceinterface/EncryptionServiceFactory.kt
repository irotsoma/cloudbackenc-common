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
/*
 * Created by irotsoma on 8/18/2016.
 */
package com.irotsoma.cloudbackenc.common.encryptionserviceinterface

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.irotsoma.cloudbackenc.common.ExtensionConfig
import com.irotsoma.cloudbackenc.common.ExtensionFactory
import java.util.*

/**
 * Encryption Service Factory interface
 *
 * @author Justin Zak
 */
abstract class EncryptionServiceFactory: ExtensionFactory {
    companion object {
        /**
         * The name of the resource file that contains the extension configuration
         */
        private const val EXTENSION_CONFIG_FILE_PATH = "encryption-service-extension.json"
    }
    /**
     * Contains the extension UUID pulled from the config json file
     */
    override final val extensionUuid: UUID
    /**
     * Contains the extension name pulled from the config json file
     */
    override final val extensionName: String
    /**
     * Reads the config file to get the UUID and Name of the current extension.
     */
    init {
        //get Json config file data
        val configFileStream = this::class.java.classLoader.getResourceAsStream(EXTENSION_CONFIG_FILE_PATH)
        val jsonValue = configFileStream.reader().readText()
        val mapper = ObjectMapper().registerModule(KotlinModule())
        val mapperData: EncryptionServiceExtensionConfig = mapper.readValue(jsonValue)
        //add values to variables for consumption later
        extensionUuid = UUID.fromString(mapperData.serviceUuid)
        extensionName = mapperData.serviceName ?: ""
    }
    /**
     * List of key algorithms that the extension supports
     *
     * EncryptionServiceSymmetricKeyAlgorithms for list of possible values
     */
    abstract val supportedSymmetricKeyAlgorithms: Array<EncryptionServiceSymmetricKeyAlgorithms>
    /**
     * List of encryption algorithms that the extension supports
     *
     * EncryptionServiceSymmetricEncryptionAlgorithms for list of possible values
     */
    abstract val supportedSymmetricEncryptionAlgorithms: Array<EncryptionServiceSymmetricEncryptionAlgorithms>
    /**
     * List of key algorithms that the extension supports
     *
     * EncryptionServiceSymmetricKeyAlgorithms for list of possible values
     */
    abstract val supportedAsymmetricKeyAlgorithms: Array<EncryptionServiceAsymmetricKeyAlgorithms>
    /**
     * List of encryption algorithms that the extension supports
     *
     * EncryptionServiceSymmetricEncryptionAlgorithms for list of possible values
     */
    abstract val supportedAsymmetricEncryptionAlgorithms: Array<EncryptionServiceAsymmetricEncryptionAlgorithms>
    /**
     * List of PBKDF Algorithms that the extension supports
     *
     * EncryptionServicePBKDFAlgorithms for list of possible values
     */
    abstract val supportedPBKDFAlgorithms: Array<EncryptionServicePBKDFAlgorithms>
    /**
     * Service that handles generation and processing of encryption keys
     */
    abstract val encryptionServiceKeyService: EncryptionServiceKeyService
    /**
     * Service that handles encryption and decryption of files
     */
    abstract val encryptionServiceFileService: EncryptionServiceFileService
    /**
     * Service that handles encryption and decryption of strings
     */
    abstract val encryptionServiceStringService: EncryptionServiceStringService
}