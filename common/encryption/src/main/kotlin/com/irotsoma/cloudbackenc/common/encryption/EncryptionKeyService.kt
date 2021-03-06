/*
 * Copyright (C) 2016-2020  Irotsoma, LLC
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

import java.security.KeyPair
import java.security.SecureRandom
import javax.crypto.SecretKey

/**
 * Interface for a service for generating keys
 *
 * @author Justin Zak
 */
interface EncryptionKeyService {

    /**
     * Generate a symmetric SecretKey using the default options of the extension
     */
    fun generateSymmetricKey(): SecretKey?
    /**
     * Generate a symmetric SecretKey specifying the algorithm and key size
     *
     * Note: Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files may be required for key sizes over 128.
     *
     * @param algorithm Algorithm to use to generate the key.
     * @param keySize Size of the key to generate in bits.
     */
    fun generateSymmetricKey(algorithm: EncryptionSymmetricKeyAlgorithms, keySize: Int): SecretKey?
    /**
     * Generate a symmetric SecretKey specifying the algorithm, key size, and implementation of SecureRandom
     *
     * Note: Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files may be required for key sizes over 128.
     *
     * @param algorithm Algorithm to use to generate the key.
     * @param keySize Size of the key to generate in bits.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    fun generateSymmetricKey(algorithm: EncryptionSymmetricKeyAlgorithms, keySize: Int, secureRandom: SecureRandom): SecretKey?

    /**
     * Generate an asymmetric KeyPair using the default options of the extension
     */
    fun generateAsymmetricKeys(): KeyPair?
    /**
     * Generate an asymmetric KeyPair specifying the algorithm and key size
     *
     * Note: Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files may be required for key sizes over 128.
     *
     * @param algorithm Algorithm to use to generate the keys.
     * @param keySize Size of the keys to generate in bits.
     */
    fun generateAsymmetricKeys(algorithm: EncryptionAsymmetricKeyAlgorithms, keySize: Int): KeyPair?
    /**
     * Generate an asymmetric KeyPair specifying the algorithm, key size, and implementation of SecureRandom
     *
     * Note: Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files may be required for key sizes over 128.
     *
     * @param algorithm Algorithm to use to generate the keys.
     * @param keySize Size of the keys to generate in bits.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    fun generateAsymmetricKeys(algorithm: EncryptionAsymmetricKeyAlgorithms, keySize: Int, secureRandom: SecureRandom): KeyPair?

    /**
     * Generate a password based symmetric SecretKey using the default options of the extension
     *
     * @param password Password to generate the SecretKey
     * @param salt Salt used for hashing of the password.
     */
    fun generatePasswordBasedKey(password:String, salt: ByteArray): SecretKey?
    /**
     * Generate a password based symmetric SecretKey
     *
     * @param password Password to generate the SecretKey
     * @param salt Salt used for hashing of the password.
     * @param algorithm Algorithm to use to generate the keys.
     * @param keySize Size of the keys to generate in bits.
     * @param iterations Number of iterations of the algorithm
     */
    fun generatePasswordBasedKey(password:String, salt: ByteArray, algorithm: EncryptionPBKDFEncryptionAlgorithms, keySize: Int, iterations: Int) : SecretKey?
}