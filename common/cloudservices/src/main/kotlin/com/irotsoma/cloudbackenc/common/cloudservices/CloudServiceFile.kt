/*
 * Copyright (C) 2016-2018  Irotsoma, LLC
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
package com.irotsoma.cloudbackenc.common.cloudservices
/**
 * Object that represents a file or directory on a cloud service provider
 *
 * @author Justin Zak
 * @property fileName Name of the file (without path information).
 * @property isDirectory True if object is a directory, otherwise false. (default is false)
 * @property isReadOnly True if the user does not have permission to modify the file, otherwise false. (default is false)
 * @property isDownloadable True if the user has permission to download the file, otherwise false. (default is true)
 * @property filePath Full path within the cloud service provider used to access the file (including file name)
 * @property fileId Cloud Service identifier for a file (if supported)
 * @property size File size in bytes.
 * @property hash SHA1 hash of the file.
 */
data class CloudServiceFile(
        val fileName: String,
        val isDirectory: Boolean = false,
        val isReadOnly: Boolean?,
        val isDownloadable: Boolean?,
        val filePath: String?,
        val fileId: String?,
        val size: Long?,
        val hash: String?)