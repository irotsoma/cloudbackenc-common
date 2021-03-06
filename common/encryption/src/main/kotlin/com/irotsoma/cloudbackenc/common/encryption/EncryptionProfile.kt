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
 * Created by irotsoma on 8/17/2018.
 */
package com.irotsoma.cloudbackenc.common.encryption

import java.util.*

/**
 * Object representing encryption settings for APIs
 *
 * @param encryptionType The type of encryption used in this profile
 * @param encryptionAlgorithm An instance of [EncryptionSymmetricEncryptionAlgorithms], [EncryptionAsymmetricEncryptionAlgorithms], or [EncryptionPBKDFEncryptionAlgorithms] that represents the algorithm used by this profile
 * @param encryptionKeyAlgorithm An instance of [EncryptionSymmetricKeyAlgorithms] or [EncryptionAsymmetricKeyAlgorithms] that represents the algorithm used to generate keys for this profile
 * @param encryptionKeySize The key size to use when generating encryption keys
 * @param encryptionBlockSize The block size of the encryption algorithm where applicable. Use null if not applicable
 * @param encryptionServiceUuid The encryption service UUID that should be used by this profile. Null to use default service.
 * @author Justin Zak
 */
class EncryptionProfile(val encryptionType: EncryptionAlgorithmTypes,
                        val encryptionAlgorithm: EncryptionAlgorithms,
                        val encryptionKeyAlgorithm: EncryptionKeyAlgorithms,
                        val encryptionKeySize: Int?,
                        val encryptionBlockSize: Int?,
                        val encryptionServiceUuid: UUID?
                        )