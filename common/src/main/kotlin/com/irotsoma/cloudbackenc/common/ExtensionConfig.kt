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

package com.irotsoma.cloudbackenc.common

import java.util.*
import kotlin.reflect.KClass

/**
 * Encryption Service Extension configuration class populated by encryption-service-extension.json from the extension's resources
 *
 * @author Justin Zak
 * @property serviceName Human readable name of service
 * @property serviceUuid Internal UUID of the service
 * @property packageName Full package name of the factory class for the service
 * @property factoryClass Name of the factory class for the service
 * @property releaseVersion Incremental version number for the release.  This allows the system to load only the latest version of an extension and is separate from the version name.
 */
open class ExtensionConfig(){
    var serviceUuid: String? = null
    var serviceName: String? = null
    var packageName: String? = null
    var factoryClass: String? = null
    var releaseVersion: Int= 0

    constructor(serviceUuid: String, serviceName: String, packageName: String, factoryClass: String, releaseVersion: Int):this(){
        this.serviceUuid=serviceUuid
        this.serviceName=serviceName
        this.packageName=packageName
        this.factoryClass=factoryClass
        this.releaseVersion=releaseVersion
    }
    /**
     * Override this if adding more fields to a customized extension object
     */
    inline fun <reified T: ExtensionFactory> generateExtension(extensionFactory: KClass<T>): Extension<T> {
        if (serviceName == null){
            throw NullPointerException("serviceName can not be empty while generating Extension object.")
        }
        return Extension<T>(UUID.fromString(serviceUuid), serviceName!!, releaseVersion, extensionFactory)
    }
}