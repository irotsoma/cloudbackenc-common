/*
 * Copyright (C) 2016  Irotsoma, LLC
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
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
/*
 * Created by irotsoma on 8/18/2016.
 */
package com.irotsoma.cloudbackenc.common.encryptionserviceinterface

import java.security.PrivateKey
import java.security.PublicKey
import java.security.SecureRandom
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

/**
 * Service for encrypting strings.
 *
 * @author Justin Zak
 */
interface EncryptionServiceStringService {
    /**
     * Implement to encrypt strings using symmetric (secret key) encryption.
     *
     * @param input String data to be encrypted.
     * @param key Secret key to be used to encrypt the string
     * @param algorithm Algorithm from [EncryptionServiceSymmetricEncryptionAlgorithms] to be used to encrypt the string.
     * @param ivParameterSpec An instance of [IvParameterSpec] that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a [SecureRandom] random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the [SecureRandom] once rather than once per call as it can be a resource intensive operation.
     * @returns String value containing the encrypted data.
     */
    fun encrypt(input: String, key: SecretKey, algorithm: EncryptionServiceSymmetricEncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?): String

    /**
     * Implement to encrypt strings using asymmetric (public key) encryption.
     *
     * @param input String data to be encrypted.
     * @param key Public key to be used to encrypt the string
     * @param algorithm Algorithm from [EncryptionServiceAsymmetricEncryptionAlgorithms] to be used to encrypt the string.
     * @param ivParameterSpec An instance of [IvParameterSpec] that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a [SecureRandom] random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the [SecureRandom] once rather than once per call as it can be a resource intensive operation.
     * @returns String value containing the encrypted data.
     */

    fun encrypt(input: String, key: PublicKey, algorithm: EncryptionServiceAsymmetricEncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?): String
    /**
     * Implement to decrypt strings using symmetric (secret key) encryption.
     *
     * @param input String data to be decrypted.
     * @param key Secret key to be used to decrypt the string
     * @param algorithm Algorithm from [EncryptionServiceSymmetricEncryptionAlgorithms] to be used to decrypt the string.
     * @param ivParameterSpec An instance of [IvParameterSpec] that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a [SecureRandom] random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the [SecureRandom] once rather than once per call as it can be a resource intensive operation.
     * @returns String value containing the encrypted data.
     */
    fun decrypt(input: String, key: SecretKey, algorithm: EncryptionServiceSymmetricEncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?): String

    /**
     * Implement to decrypt strings using asymmetric (public key) encryption.
     *
     * @param input String data to be decrypted.
     * @param key Public key to be used to decrypt the string
     * @param algorithm Algorithm from [EncryptionServiceAsymmetricEncryptionAlgorithms] to be used to decrypt the string.
     * @param ivParameterSpec An instance of [IvParameterSpec] that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a [SecureRandom] random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the [SecureRandom] once rather than once per call as it can be a resource intensive operation.
     * @returns String value containing the encrypted data.
     */
    fun decrypt(input: String, key: PrivateKey, algorithm: EncryptionServiceAsymmetricEncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?): String
}