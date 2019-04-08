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
package com.irotsoma.cloudbackenc.common.encryption

/**
 * A list of symmetric encryption key algorithms that extensions can support.
 *
 * @author Justin Zak
 * @property value The value should be the standard string representations of the algorithms.
 */
enum class EncryptionAsymmetricKeyAlgorithms(override val value: String): EncryptionKeyAlgorithms {
    /**
     * RSA encryption key algorithm
     */
    RSA("RSA"){
        override fun validKeyLengths(): List<Int>{
            return listOf(1024, 2048, 3072, 4096)
        }
    }
    ;

    /**
     * The list of valid key strengths in bits
     *
     * Suggest to be put in ascending numeric order.  And for algorithms with ranges, use steps.  For example RSA is 1024-4096, so I've used steps of 1024 to simplify things.
     *
     * @return A list of integer values that the user should be allowed to select for the key size of the algorithm.
     */
    abstract fun validKeyLengths() : List<Int>
}