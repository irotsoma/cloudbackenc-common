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
 * Created by irotsoma on 7/27/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservice

import java.util.*

/**
 * Cloud Service Extension object
 *
 * Used to refer to an extension.
 *
 * @author Justin Zak
*/

class CloudServiceExtension {
    /**
     * UUID of the cloud service extension from the cloud-service-extension.json
     */
    var uuid: UUID
    /**
     * Human readable name of service
     */
    var name: String
    /**
     * Token for the application to access the cloud service provider (if needed).
     */
    var token: String

    /**
     * Initialize the extension object with a random UUID and empty name
     */
    constructor(){
        this.uuid = UUID.randomUUID()
        name = ""
        token = ""
    }

    /**
     * Initialize the extension object with the uuid and name of the extension
     */
    constructor(uuid: UUID, name: String){
        this.uuid = uuid
        this.name = name
        token = ""
    }
    /**
     * Initialize the extension object with the uuid, name, and authorization token
     */
    constructor(uuid: UUID, name: String, token: String){
        this.token = token
        this.uuid = uuid
        this.name = name
    }
}