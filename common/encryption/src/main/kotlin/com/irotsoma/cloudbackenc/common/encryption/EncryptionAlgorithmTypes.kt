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
 * The type of encryption
 *
 * @author Justin Zak
 * @property value The value should be the standard string representations of the types.
 */
enum class EncryptionAlgorithmTypes(val value: String) {
    /**
     * Symmetric encryption using a single secret key
     */
    SYMMETRIC("Symmetric"),
    /**
     * Asymmetric encryption using a pair of keys, public/private
     */
    ASYMMETRIC("Asymmetric"),
    /**
     * Password based encryption without keys
     */
    PBKDF("PBKDF")
}