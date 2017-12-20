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

import com.irotsoma.cloudbackenc.common.Extension
import java.util.*

/**
 * Cloud Service Extension object
 *
 * Used to as a serializable object referring to an extension.
 *
 * @author Justin Zak
*/

class CloudServiceExtension: Extension {
    companion object{
        const val serialVersionUID = 84685165165
    }
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
    constructor(): super(UUID.randomUUID(),""){
        token = ""
        requiresUsername = false
        requiresPassword = false
    }

    /**
     * Initialize the extension object with the uuid and name of the extension
     */
    constructor(uuid: UUID, name: String): super(uuid,name){
        token = ""
        requiresUsername = false
        requiresPassword = false
    }
    /**
     * Initialize the extension object with the uuid, name of the extension, and flags for requires username and/or
     * password
     */
    constructor(uuid: UUID, name: String, requiresUsername: Boolean, requiresPassword: Boolean): super(uuid,name){
        token = ""
        this.requiresUsername = requiresUsername
        this.requiresPassword = requiresPassword
    }
    /**
     * Initialize the extension object with the uuid, name, and authorization token
     */
    constructor(uuid: UUID, name: String, token: String):super(uuid, name){
        this.token = token
        requiresUsername = false
        requiresPassword = false
    }
    /**
     * Initialize the extension object with the uuid, name, authorization token, and flags for requires username and/or
     * password
     */
    constructor(uuid: UUID, name: String, token: String, requiresUsername: Boolean, requiresPassword: Boolean): super(uuid,name){
        this.token = token
        this.requiresUsername = requiresUsername
        this.requiresPassword = requiresPassword
    }

    /**
     * Determines if two instances of CloudServiceExtension are equal by comparing the uuid and name.  Both must be the
     * same.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is CloudServiceExtension){
            false
        } else {
            (other.uuid == this.uuid) && (other.name == this.name)
        }
    }

    /**
     * Generates a hash code based on the UUID and name.
     */
    override fun hashCode(): Int {
        var result = uuid.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}