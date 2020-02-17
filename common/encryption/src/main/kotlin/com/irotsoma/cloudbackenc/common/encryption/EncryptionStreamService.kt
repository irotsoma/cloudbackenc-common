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

import java.io.InputStream
import java.io.OutputStream
import java.security.Key
import java.security.PrivateKey
import java.security.PublicKey
import java.security.SecureRandom
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

/**
 * Collection of functions for encrypting and decrypting streams.
 *
 * @author Justin Zak
 */
abstract class EncryptionStreamService {
    /**
     * Encryption function implementation to disambiguate between symmetric and asymmetric functions.
     *
     * @param inputStream Input stream for the data to be encrypted.
     * @param outputStream Output stream for the data after encryption
     * @param key Key to be used to encrypt the data.  Must be an instance of SecretKey for symmetric algorithms or PublicKey for asymmetric algorithms.
     * @param algorithm Algorithm from EncryptionSymmetricEncryptionAlgorithms or EncryptionAsymmetricEncryptionAlgorithms to be used to encrypt the data.  Must match with the appropriate key type.
     * @param ivParameterSpec An instance of IvParameterSpec that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    fun encrypt(inputStream: InputStream, outputStream: OutputStream, key: Key, algorithm: EncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?){
        //smart cast to the appropriate function call (symmetric or asymmetric
        if ((algorithm is EncryptionSymmetricEncryptionAlgorithms) && (key is SecretKey)){
            encrypt(inputStream,outputStream, key, algorithm, ivParameterSpec,secureRandom )
        } else if ((algorithm is EncryptionAsymmetricEncryptionAlgorithms) && (key is PublicKey)){
            encrypt(inputStream,outputStream, key, algorithm, secureRandom )
        } else {
            throw EncryptionException("Encryption key and algorithm mismatch.")
        }
    }
    /**
     * Implement to encrypt data streams using symmetric (secret key) encryption.
     *
     * @param inputStream Input stream for the data to be encrypted.
     * @param outputStream Output stream for the data after encryption
     * @param key Secret key to be used to encrypt the data
     * @param algorithm Algorithm from EncryptionSymmetricEncryptionAlgorithms to be used to encrypt the data.
     * @param ivParameterSpec An instance of IvParameterSpec that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    abstract fun encrypt(inputStream: InputStream, outputStream: OutputStream, key: SecretKey, algorithm: EncryptionSymmetricEncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?)
    /**
     * Implement to encrypt data streams using asymmetric (public key) encryption.
     *
     * @param inputStream Input stream for the data to be encrypted.
     * @param outputStream Output stream for the data after encryption
     * @param key Public key to be used to encrypt the data
     * @param algorithm Algorithm from EncryptionAsymmetricEncryptionAlgorithms to be used to encrypt the data.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    abstract fun encrypt(inputStream: InputStream, outputStream: OutputStream, key: PublicKey, algorithm: EncryptionAsymmetricEncryptionAlgorithms, secureRandom: SecureRandom?)
    /**
     * Decryption function implementation to disambiguate between symmetric and asymmetric functions.
     *
     * @param inputStream Input stream for the data to be encrypted.
     * @param outputStream Output stream for the data after encryption
     * @param key Key to be used to encrypt the data.  Must be an instance of SecretKey for symmetric algorithms or PrivateKey for asymmetric algorithms.
     * @param algorithm Algorithm from EncryptionSymmetricEncryptionAlgorithms or EncryptionAsymmetricEncryptionAlgorithms to be used to encrypt the data.  Must match with the appropriate key type.
     * @param ivParameterSpec An instance of IvParameterSpec that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    fun decrypt(inputStream: InputStream, outputStream: OutputStream, key: Key, algorithm: EncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?){
        //smart cast to the appropriate function call (symmetric or asymmetric)
        if ((algorithm is EncryptionSymmetricEncryptionAlgorithms) && (key is SecretKey)){
            decrypt(inputStream,outputStream, key, algorithm, ivParameterSpec,secureRandom )
        } else if ((algorithm is EncryptionAsymmetricEncryptionAlgorithms) && (key is PrivateKey)){
            decrypt(inputStream,outputStream, key, algorithm, secureRandom )
        } else {
            throw EncryptionException("Encryption key and algorithm mismatch.")
        }
    }
    /**
     * Implement to decrypt data streams using symmetric (secret key) encryption.
     *
     * @param inputStream Input stream for the data to be decrypted.
     * @param outputStream Output stream for the data after decryption
     * @param key Secret key to be used to decrypt the data
     * @param algorithm Algorithm from EncryptionSymmetricEncryptionAlgorithms to be used to decrypt the data.
     * @param ivParameterSpec An instance of IvParameterSpec that contains the initialization vector for encryption algorithms that require it.  Use null if not required by the algorithm.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    abstract fun decrypt(inputStream: InputStream, outputStream: OutputStream, key: SecretKey, algorithm: EncryptionSymmetricEncryptionAlgorithms, ivParameterSpec: IvParameterSpec?, secureRandom: SecureRandom?)
    /**
     * Implement to decrypt data streams using asymmetric (public key) encryption.
     *
     * @param inputStream Input stream for the data to be decrypted.
     * @param outputStream Output stream for the data after decryption
     * @param key Secret key to be used to decrypt the data
     * @param algorithm Algorithm from EncryptionAsymmetricEncryptionAlgorithms to be used to decrypt the data.
     * @param secureRandom An instance of a SecureRandom random number generator.  If not sent, a new one will be generated using the default Java algorithm.  If encrypting or decrypting lots of files or strings, it is recommended to generate the SecureRandom once rather than once per call as it can be a resource intensive operation.
     */
    abstract fun decrypt(inputStream: InputStream, outputStream: OutputStream, key: PrivateKey, algorithm: EncryptionAsymmetricEncryptionAlgorithms, secureRandom: SecureRandom?)
}