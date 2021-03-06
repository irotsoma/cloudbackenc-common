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
 * A list of symmetric encryption key algorithms that extensions can support.
 *
 * @author Justin Zak
 * @property value The value should be the standard string representations of the algorithms.
 */
enum class EncryptionSymmetricKeyAlgorithms(override val value: String): EncryptionKeyAlgorithms {
    //TODO:  Add more algorithms and remove insecure ones.
    /**
     * AES encryption key algorithm
     */
    AES("AES") {
        override fun validKeyLengths(): List<Int>
        {
            return listOf(128, 192, 256)
        }
    },
    /**
     * SKIPJACK encryption key algorithm
     */
    SKIPJACK("SKIPJACK"){
        override fun validKeyLengths(): List<Int>
        {
            return listOf(80)
        }
    },
    /**
     * Twofish encryption key algorithm
     */
    TWOFISH("Twofish"){
        override fun validKeyLengths(): List<Int>
        {
            return listOf(128, 192, 256)
        }
    },
    /**
     * Blowfish encryption key algorithm
     */
    BLOWFISH("Blowfish"){
        override fun validKeyLengths(): List<Int>
        {
            return listOf(32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448)
        }
    };

    /**
     * The list of valid key strengths in bits
     *
     * Suggest to be put in ascending numeric order.  And for algorithms with ranges, use steps.  For example Blowfish is 32-448, so I've used steps of 32 to simplify things.
     *
     * @return A list of integer values that the user should be allowed to select for the key size of the algorithm.
     */
    abstract fun validKeyLengths() : List<Int>
}