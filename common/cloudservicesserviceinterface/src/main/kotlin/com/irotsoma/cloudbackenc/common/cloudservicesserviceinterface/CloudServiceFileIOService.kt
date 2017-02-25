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
 * Created by irotsoma on 6/20/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import com.irotsoma.cloudbackenc.common.CloudBackEncUser
import java.io.File
import java.io.InputStream

/**
 * Interface for Cloud Service IO operations
 *
 * @author Justin Zak
 */
interface CloudServiceFileIOService {
    /**
     * Implement to upload a file to a cloud service provider.
     *
     * @param filePath A [File] object that points to the file to be uploaded.
     * @param uploadedFilePath The path on the cloud service to place the uploaded file including file name.
     * @param user A [CloudBackEncUser] object that represents the currently logged in user.
     * @returns A [CloudServiceFile] representing the file that was uploaded or null if the file was not successfully uploaded
     */
    fun upload(filePath: File, uploadedFilePath: String, user: CloudBackEncUser) : CloudServiceFile?

    /**
     * Implement to get a list of files and directories from the specified directory on the cloud service.
     *
     * @param dirPath The path within the cloud service provider for which to return a listing.
     * @param user A [CloudBackEncUser] object that represents the currently logged in user.
     * @return List of [CloudServiceFile] objects that represents the listing returned by the cloud service
     */
    fun list(dirPath: String, user: CloudBackEncUser) : List<CloudServiceFile>

    /**
     * Implement to download a file from the cloud service provider.
     *
     * @param filePath The path within the cloud service provider for the file to be downloaded.
     * @param user A [CloudBackEncUser] object that represents the currently logged in user.
     * @return An input stream to the file downloaded.
     */
    fun download(filePath: String, user: CloudBackEncUser) : InputStream

    /**
     * Implement to delete a file from the cloud service provider
     *
     * @param targetPath The path within the cloud service provider for the file or directory to be deleted.
     * @param user A [CloudBackEncUser] object that represents the currently logged in user.
     * @return True if file was successfully deleted.  Otherwise, false.
     */
    fun delete(targetPath:String, user: CloudBackEncUser) : Boolean

    /**
     * Implement to return the current available space on the cloud service provider.
     *
     * @param user A [CloudBackEncUser] object that represents the currently logged in user.
     * @return Available space in bytes
     */
    fun availableSpace(user: CloudBackEncUser):Long
}