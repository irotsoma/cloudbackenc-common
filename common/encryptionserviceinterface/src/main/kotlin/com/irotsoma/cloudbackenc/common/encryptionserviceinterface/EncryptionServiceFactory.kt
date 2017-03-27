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

/**
 * Encryption Service Factory interface
 *
 * @author Justin Zak
 */
interface EncryptionServiceFactory {
    /**
     * List of key algorithms that the extension supports
     *
     * [EncryptionServiceSymmetricKeyAlgorithms] for list of possible values
     */
    val supportedSymmetricKeyAlgorithms: Array<EncryptionServiceSymmetricKeyAlgorithms>
    /**
     * List of encryption algorithms that the extension supports
     *
     * [EncryptionServiceSymmetricEncryptionAlgorithms] for list of possible values
     */
    val supportedSymmetricEncryptionAlgorithms: Array<EncryptionServiceSymmetricEncryptionAlgorithms>
    /**
     * List of key algorithms that the extension supports
     *
     * [EncryptionServiceSymmetricKeyAlgorithms] for list of possible values
     */
    val supportedAsymmetricKeyAlgorithms: Array<EncryptionServiceAsymmetricKeyAlgorithms>
    /**
     * List of encryption algorithms that the extension supports
     *
     * [EncryptionServiceSymmetricEncryptionAlgorithms] for list of possible values
     */
    val supportedAsymmetricEncryptionAlgorithms: Array<EncryptionServiceAsymmetricEncryptionAlgorithms>
    /**
     * List of PBKDF Algorithms that the extension supports
     *
     * [EncryptionServicePBKDFAlgorithms] for list of possible values
     */
    val supportedPBKDFAlgorithms: Array<EncryptionServicePBKDFAlgorithms>
    /**
     * Service that handles generation and processing of encryption keys
     */
    val encryptionServiceKeyService: EncryptionServiceKeyService
    /**
     * Service that handles encryption and decryption of files
     */
    val encryptionServiceFileService: EncryptionServiceFileService
    /**
     * Service that handles encryption and decryption of strings
     */
    val encryptionServiceStringService: EncryptionServiceStringService
}