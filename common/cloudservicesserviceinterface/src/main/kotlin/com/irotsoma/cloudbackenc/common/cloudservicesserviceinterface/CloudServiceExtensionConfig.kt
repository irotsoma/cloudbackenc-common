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
 * Created by irotsoma on 7/8/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import com.irotsoma.cloudbackenc.common.ExtensionConfig

/**
 * Cloud Service Extension configuration class
 *
 * Populated by cloud-service-extension.json from the extension's resources.
 *
 * @author Justin Zak
 * @property requiresUsername Indicates that the client must provide a username upfront rather than it being provided to an external validation site.
 * @property requiresPassword Indicates that the client must provide a password upfront rather than it being provided to an external validation site.
 */
class CloudServiceExtensionConfig(): ExtensionConfig() {
    var requiresUsername: Boolean = false
    var requiresPassword: Boolean = false

    constructor(serviceUuid: String, serviceName: String, releaseVersion: Int) : this(){
        this.serviceUuid = serviceUuid
        this.serviceName = serviceName
        this.releaseVersion = releaseVersion
    }

    constructor(serviceUuid: String, serviceName: String, packageName: String, factoryClass: String, releaseVersion: Int) : this() {
        this.serviceUuid = serviceUuid
        this.serviceName = serviceName
        this.packageName = packageName
        this.factoryClass = factoryClass
        this.releaseVersion = releaseVersion
    }

    constructor(serviceUuid: String, serviceName: String, packageName: String, factoryClass: String, releaseVersion: Int, requiresUsername: Boolean, requiresPassword: Boolean) : this() {
        this.serviceUuid=serviceUuid
        this.serviceName=serviceName
        this.packageName=packageName
        this.factoryClass=factoryClass
        this.releaseVersion=releaseVersion
        this.requiresUsername = requiresUsername
        this.requiresPassword = requiresPassword
    }

    /**
     * Determines if two instances of CloudServiceExtensionConfig are equal by comparing the uuid and name.  Both must be the
     * same.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is CloudServiceExtensionConfig){
            false
        } else {
            (other.serviceUuid == this.serviceUuid) && (other.serviceName == this.serviceName) && (other.releaseVersion == this.releaseVersion)
        }
    }

    /**
     * Generates a hash code based on the UUID, name, and version.
     */
    override fun hashCode(): Int {
        return (serviceUuid?.hashCode() ?:0) + (serviceName?.hashCode() ?:0) + releaseVersion.hashCode()
    }
}


