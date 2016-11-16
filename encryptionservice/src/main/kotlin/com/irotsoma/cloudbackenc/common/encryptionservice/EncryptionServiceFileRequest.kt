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
 * Created by irotsoma on 10/31/16.
 */
package com.irotsoma.cloudbackenc.common.encryptionservice

import java.security.Key
import java.security.SecureRandom
import javax.crypto.spec.IvParameterSpec

/**
 * A class used to send information about a file to be encrypted or decrypted and the encryption parameters.
 *
 * @author Justin Zak
 * @property filePath The full path to the file as it will be accessed by the receiver.
 * @property algorithm The encryption algorithm to use as a value of [EncryptionServiceEncryptionAlgorithms].
 * @property key The encryption key to use to encrypt the file.
 * @property ivParameterSpec (Optional) An instance of [IvParameterSpec] needed to encrypt the file if the encryption algorithm requires it.
 * @property secureRandom (Optional) An instance of [SecureRandom]. To prevent the system from creating a new instance for every file, create a single instance and use it for each call.  This will improve performance on large batches.
 */
class EncryptionServiceFileRequest(
    val filePath : String,
    val algorithm: EncryptionServiceEncryptionAlgorithms,
    val key: Key,
    val ivParameterSpec: IvParameterSpec?,
    val secureRandom: SecureRandom?
)
