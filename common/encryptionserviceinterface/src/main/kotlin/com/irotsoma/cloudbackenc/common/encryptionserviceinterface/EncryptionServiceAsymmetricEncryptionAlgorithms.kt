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
    RSA("RSA"),
    /**
     * RSA in PKCS1 mode
     */
    RSA_PKCS1("RSA/PKCS1"),
    /**
     * RSA in the default mode with PKCS1 padding
     */
    RSA__PKCS1PADDING("RSA//PKCS1PADDING")

}