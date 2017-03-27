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
 * Created by irotsoma on 7/27/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

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
     * Token for the application to access the cloud service provider (if needed to be stored by client rather than
     * server).
     */
    var token: String
    /**
     * Flag to specify that the client must supply a username
     */
    var requiresUsername: Boolean
    /**
     * Flag to specify that the client must supply a password
     */
    var requiresPassword: Boolean


    /**
     * Initialize the extension object with a random UUID and empty name
     */
    constructor(){
        this.uuid = UUID.randomUUID()
        name = ""
        token = ""
        requiresUsername = false
        requiresPassword = false
    }

    /**
     * Initialize the extension object with the uuid and name of the extension
     */
    constructor(uuid: UUID, name: String){
        this.uuid = uuid
        this.name = name
        token = ""
        requiresUsername = false
        requiresPassword = false
    }
    /**
     * Initialize the extension object with the uuid, name of the extension, and flags for requires username and/or
     * password
     */
    constructor(uuid: UUID, name: String, requiresUsername: Boolean, requiresPassword: Boolean){
        this.uuid = uuid
        this.name = name
        token = ""
        this.requiresUsername = requiresUsername
        this.requiresPassword = requiresPassword
    }
    /**
     * Initialize the extension object with the uuid, name, and authorization token
     */
    constructor(uuid: UUID, name: String, token: String){
        this.token = token
        this.uuid = uuid
        this.name = name
        requiresUsername = false
        requiresPassword = false
    }
    /**
     * Initialize the extension object with the uuid, name, authorization token, and flags for requires username and/or
     * password
     */
    constructor(uuid: UUID, name: String, token: String, requiresUsername: Boolean, requiresPassword: Boolean){
        this.token = token
        this.uuid = uuid
        this.name = name
        this.requiresUsername = requiresUsername
        this.requiresPassword = requiresPassword
    }
}