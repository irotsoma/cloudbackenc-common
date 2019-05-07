/*
 * Copyright (C) 2016-2019  Irotsoma, LLC
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
package com.irotsoma.cloudbackenc.common.cloudservices

import com.irotsoma.cloudbackenc.common.Extension
import java.io.Serializable
import java.util.*

/**
 * Cloud Service Extension configuration class
 *
 * Populated by cloud-service-extension.json from the extension's resources.
 *
 * @author Justin Zak
 * @property requiresUsername Indicates that the client must provide a username upfront rather than it being provided to an external validation site.
 * @property requiresPassword Indicates that the client must provide a password upfront rather than it being provided to an external validation site.
 * @property additionalSettings Stores any custom settings needed for a cloud service extension
 */
class CloudServiceExtension(): Extension() {
    var requiresUsername: Boolean = false
    var requiresPassword: Boolean = false
    var additionalSettings:HashMap<String, String> = HashMap()

    /**
     * @param extensionUuid the UUID of the extension
     * @param extensionName the human readable name of the extension
     * @param releaseVersion the numerical release version of the extension
     */
    constructor(extensionUuid: String, extensionName: String, releaseVersion: Int) : this(){
        this.extensionUuid = extensionUuid
        this.extensionName = extensionName
        this.releaseVersion = releaseVersion
    }
    /**
     * @param extensionUuid the UUID of the extension
     * @param extensionName the human readable name of the extension
     * @param releaseVersion the numerical release version of the extension
     * @param packageName the package name containing the factory class of the extension
     * @param factoryClass the name of the factory class for the extension
     */
    constructor(extensionUuid: String, extensionName: String, packageName: String, factoryClass: String, releaseVersion: Int) : this() {
        this.extensionUuid = extensionUuid
        this.extensionName = extensionName
        this.packageName = packageName
        this.factoryClass = factoryClass
        this.releaseVersion = releaseVersion
    }
    /**
     * @param extensionUuid the UUID of the extension
     * @param extensionName the human readable name of the extension
     * @param releaseVersion the numerical release version of the extension
     * @param packageName the package name containing the factory class of the extension
     * @param factoryClass the name of the factory class for the extension
     * @param requiresUsername Indicates that the client must provide a username upfront rather than it being provided to an external validation site.
     * @param requiresPassword Indicates that the client must provide a password upfront rather than it being provided to an external validation site.
     */
    constructor(extensionUuid: String, extensionName: String, packageName: String, factoryClass: String, releaseVersion: Int, requiresUsername: Boolean, requiresPassword: Boolean) : this() {
        this.extensionUuid =extensionUuid
        this.extensionName =extensionName
        this.packageName=packageName
        this.factoryClass=factoryClass
        this.releaseVersion=releaseVersion
        this.requiresUsername = requiresUsername
        this.requiresPassword = requiresPassword
    }

    /**
     * Determines if two instances of CloudServiceExtension are equal by comparing the uuid and version.  Both must be the same.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is CloudServiceExtension){
            false
        } else {
            (other.extensionUuid == this.extensionUuid) && (other.releaseVersion == this.releaseVersion)
        }
    }

    /**
     * Generates a hash code based on the UUID and version.
     */
    override fun hashCode(): Int {
        return (extensionUuid.hashCode()) + releaseVersion.hashCode()
    }
}

/**
 * Object for passing a list of CloudServiceExtension through a REST API
 *
 * @author Justin Zak
 */
class CloudServiceExtensionList() : Serializable, ArrayList<CloudServiceExtension>() {
    /** Companion Object to hold the serialVersionUID */
    companion object {
        /** UID for this class for java's Serializable object */
        const val serialVersionUID = 84685165165
    }

    /**
     * @param list A [List] of CloudServiceExtension objects to add to this class
     */
    constructor(list: List<CloudServiceExtension>) : this(){
        for (extension in list){
            this.add(extension)
        }
    }
}
