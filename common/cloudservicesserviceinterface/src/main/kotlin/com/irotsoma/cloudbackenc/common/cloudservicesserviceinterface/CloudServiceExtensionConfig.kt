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
 * @property serviceName Human readable name of service
 * @property serviceUuid Internal UUID of the service from the cloud-service-extension.json file.
 * @property packageName Full package name of the factory class for the service
 * @property factoryClass Name of the factory class for the service
 * @property releaseVersion Incremental version number for the release.  This allows the system to load only the latest version of an extension and is separate from the version name.
 * @property requiresUsername Indicates that the client must provide a username upfront rather than it being provided to an external validation site.
 * @property requiresPassword Indicates that the client must provide a password upfront rather than it being provided to an external validation site.
 */
class CloudServiceExtensionConfig(
        serviceUuid: String,
        serviceName: String,
        packageName: String,
        factoryClass: String,
        releaseVersion: Int,
        val requiresUsername: Boolean,
        val requiresPassword: Boolean
        ): ExtensionConfig(serviceUuid,serviceName,packageName,factoryClass,releaseVersion)

