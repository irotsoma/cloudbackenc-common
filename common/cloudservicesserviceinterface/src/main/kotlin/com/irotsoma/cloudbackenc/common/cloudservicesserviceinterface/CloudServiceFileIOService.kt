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
     * @returns True if file is successfully uploaded.  Otherwise, false.
     */
    fun upload(filePath: File) : Boolean

    /**
     * Implement to get a list of files and directories from the specified directory on the cloud service.
     *
     * @param dirPath The path within the cloud service provider for which to return a listing.
     * @return List of [CloudServiceFile] objects that represents the listing returned by the cloud service
     */
    fun list(dirPath: String) : List<CloudServiceFile>

    /**
     * Implement to download a file from the cloud service provider.
     *
     * @param filePath The path within the cloud service provider for the file to be downloaded.
     * @return An input stream to the file downloaded.
     */
    fun download(filePath: String) : InputStream

    /**
     * Implement to delete a file from the cloud service provider
     *
     * @param targetPath The path within the cloud service provider for the file or directory to be deleted.
     * @return True if file was successfully deleted.  Otherwise, false.
     */
    fun delete(targetPath:String) : Boolean
}