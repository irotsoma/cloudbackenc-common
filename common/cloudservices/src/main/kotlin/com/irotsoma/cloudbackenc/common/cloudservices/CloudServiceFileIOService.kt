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
 * Created by irotsoma on 6/20/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservices

import com.irotsoma.cloudbackenc.common.CloudBackEncUser
import java.io.File
import java.io.InputStream
import java.nio.file.Path
import java.util.*

/**
 * Abstract class for Cloud Service IO operations
 *
 * @author Justin Zak
 * @property extensionUuid The UUID of the current extension.
 */
abstract class CloudServiceFileIOService(var extensionUuid: UUID) {
    /**
     * Implement to upload a file to a cloud service provider.
     *
     * @param filePath A File object that points to the file to be uploaded.
     * @param uploadedFilePath The path on the cloud service to place the uploaded file including file name.
     * @param user A CloudBackEncUser object that represents the currently logged in user.
     * @return A CloudServiceFile representing the file that was uploaded or null if the file was not successfully uploaded
     */
    abstract fun upload(filePath: File, uploadedFilePath: Path, user: CloudBackEncUser) : CloudServiceFile?

    /**
     * Implement to get a list of files and directories from the specified directory on the cloud service.
     *
     * @param query A query string for which to return a list. Depending on the provider this may be a path or a search query string.
     * @param user A CloudBackEncUser object that represents the currently logged in user.
     * @return List of CloudServiceFile objects that represents the listing returned by the cloud service
     */
    abstract fun list(query: String, user: CloudBackEncUser) : List<CloudServiceFile>

    /**
     * Implement to download a file from the cloud service provider.
     *
     * @param file The CloudServiceFile object representing the file within the cloud service provider to be downloaded.
     * @param user A CloudBackEncUser object that represents the currently logged in user.
     * @return An input stream to the file downloaded.
     */
    abstract fun download(file: CloudServiceFile, user: CloudBackEncUser) : InputStream

    /**
     * Implement to delete a file from the cloud service provider
     *
     * @param targetFile The CloudServiceFile object representing the file within the cloud service provider to be deleted.
     * @param user A CloudBackEncUser object that represents the currently logged in user.
     * @return True if file was successfully deleted.  Otherwise, false.
     */
    abstract fun delete(targetFile: CloudServiceFile, user: CloudBackEncUser) : Boolean

    /**
     * Implement to return the current available space on the cloud service provider.
     *
     * Note: implementation for if user is over limit should return 0, not a negative number.  Only unlimited should return -1.
     *
     * @param user A CloudBackEncUser object that represents the currently logged in user.
     * @return Available space in bytes, -1 if unlimited, null if unknown or error, 0 if user is over limit
     */
    abstract fun availableSpace(user: CloudBackEncUser):Long?
}