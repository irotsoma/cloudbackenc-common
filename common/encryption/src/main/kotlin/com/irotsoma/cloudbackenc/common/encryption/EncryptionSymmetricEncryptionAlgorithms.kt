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
 * Created by irotsoma on 8/26/2016.
 */
package com.irotsoma.cloudbackenc.common.encryption

/**
 * A list of encryption algorithms that extensions can support.
 *
 * @author Justin Zak
 * @property value The value should be the standard string representations of the algorithms.
 */
enum class EncryptionSymmetricEncryptionAlgorithms(override val value: String): EncryptionAlgorithms {
    //TODO:  Add more algorithms and remove insecure ones.
    // This is just a quick list of algorithms supported by bouncycastle/apache commons crypto
    /**
     * AES algorithm using default mode for the library used
     */
    AES("AES"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.AES
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(128)
        }
    },
    /**
     * AES algorithm in CBC mode with PKCS5Padding padding algorithm
     */
    AES_CBC_PKCS5PADDING("AES/CBC/PKCS5Padding"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.AES
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(128)
        }
    },
    /**
     * AES algorithm in CBC mode with CTS padding algorithm
     */
    AES_CBC_WITHCTS("AES/CBC/WithCTS"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.AES
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(128)
        }
    },
    /**
     * AES algorithm in ECB mode with PKCS5Padding padding algorithm
     */
    AES_ECB_PKCS5PADDING("AES/ECB/PKCS5Padding"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.AES
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(128)
        }
    },
    /**
     * AES algorithm in ECB mode with CTS padding algorithm
     */
    AES_ECB_WITHCTS("AES/ECB/WithCTS"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.AES
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(128)
        }
    },
    /**
     * SKIPJACK algorithm in ECB mode with PKCS7Padding padding algorithm
     */
    SKIPJACK_ECB_PKCS7PADDING("SKIPJACK/ECB/PKCS7Padding"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.SKIPJACK
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(64)
        }
    },
    /**
     * Twofish algorithm in CBC mode with PKCS5Padding padding algorithm
     */
    TWOFISH_CBC_PKCS5PADDING("Twofish/CBC/PKCS5Padding"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.TWOFISH
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(128)
        }
    },
    /**
     * Blowfish algorithm in CBC mode with PKCS5Padding padding algorithm
     */
    BLOWFISH_CBC_PKCS5PADDING("Blowfish/CBC/PKCS5Padding"){
        override fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms {
            return EncryptionSymmetricKeyAlgorithms.BLOWFISH
        }
        override fun validBlockSizes(): List<Int>        {
            return listOf(64)
        }
    };

    /**
     * The list of valid block sizes for generating initialization vectors in bits (or -1 if initialization vector is not used)
     *
     * Suggest to be put in ascending numeric order.  And for algorithms with ranges, use steps.  For example Blowfish is 32-448, so I've used steps of 32 to simplify things.
     *
     * @return A list of integer values that the user should be allowed to select for the key size of the algorithm.
     */
    abstract fun validBlockSizes() : List<Int>

    /**
     * The key algorithm to be used with this encryption algorithm
     **/
    abstract fun keyAlgorithm(): EncryptionSymmetricKeyAlgorithms
}