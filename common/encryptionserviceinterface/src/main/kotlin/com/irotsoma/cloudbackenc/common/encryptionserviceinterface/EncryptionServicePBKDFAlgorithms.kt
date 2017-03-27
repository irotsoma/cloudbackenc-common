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
 * Created by irotsoma on 8/31/2016.
 */
package com.irotsoma.cloudbackenc.common.encryptionserviceinterface


/**
 * List of PBKDF2 (Password-Based Key Derivation Function 2) key algorithms that extensions can support.
 *
 * @author Justin Zak
 * @property value The value should be the standard string representations of the algorithms.
 */
enum class EncryptionServicePBKDFAlgorithms(val value: String) {
    //TODO:  Add more algorithms
    /**
     * PBKDF2 with Hmac using SHA1
     */
    PBKDF2WithHmacSHA1("PBKDF2WithHmacSHA1"),
    /**
     * PBKDF2 with Hmac using SHA512
     */
    PBKDF2WithHmacSHA512("PBKDF2WithHmacSHA512")
}