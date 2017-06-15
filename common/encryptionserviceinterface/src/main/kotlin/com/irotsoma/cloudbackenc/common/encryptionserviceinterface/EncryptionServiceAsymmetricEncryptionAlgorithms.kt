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
 * Created by irotsoma on 10/20/16.
 */
package com.irotsoma.cloudbackenc.common.encryptionserviceinterface

/**
 * A list of encryption algorithms that extensions can support.
 *
 * @author Justin Zak
 * @property value The value should be the standard string representations of the algorithms.
 */
enum class EncryptionServiceAsymmetricEncryptionAlgorithms(val value: String): EncryptionServiceEncryptionAlgorithms {
    //TODO:  Add more algorithms and remove insecure ones.
    /**
     * RSA encryption using the default mode for the library used.
     */
    RSA("RSA") {
        override fun maxDataSize(): Map<Int,Int> {
            return mapOf(Pair(1024,127),Pair(2048,255), Pair(3072,383), Pair(4096,511))
        }
    },
    /**
     * RSA in the ECB mode with PKCS1 padding
     */
    RSA_ECB_PKCS1PADDING("RSA/ECB/PKCS1PADDING"){
        override fun maxDataSize(): Map<Int,Int> {
            return mapOf(Pair(1024,117),Pair(2048,245), Pair(3072,373), Pair(4096,501))
        }
    },
    /**
     * RSA in the ECB mode with OAEP with SHA1 and MGF1 padding
     */
    RSA_ECB_OAEPWithSHA1AndMGF1Padding("RSA/ECB/OAEPWithSHA-1AndMGF1Padding"){
        override fun maxDataSize(): Map<Int,Int> {
            return mapOf(Pair(1024,86),Pair(2048,214), Pair(3072,342), Pair(4096,470))
        }
    },
    /**
     * RSA in the ECB mode with OAEP with SHA256 and MGF1 padding
     */
    RSA_ECB_OAEPWithSHA256AndMGF1Padding("RSA/ECB/OAEPWithSHA-256AndMGF1Padding"){
        override fun maxDataSize(): Map<Int,Int> {
            return mapOf(Pair(1024,62),Pair(2048,190), Pair(3072,318), Pair(4096,446))
        }
    };

    /**
     * Maximum number of bytes allowed in the data being encrypted.
     */
    abstract fun maxDataSize() : Map<Int,Int>
}