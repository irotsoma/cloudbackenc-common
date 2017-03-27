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
 * Created by irotsoma on 6/20/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

/**
 * Cloud Service Factory interface
 *
 * @author Justin Zak
 */
interface CloudServiceFactory {
    /**
     * Instance of [CloudServiceAuthenticationService] for the cloud service implementation.
     */
     val authenticationService: CloudServiceAuthenticationService
    /**
     * Instance of [CloudServiceFileIOService] for the cloud service implementation.
     */
     val cloudServiceFileIOService: CloudServiceFileIOService
}

