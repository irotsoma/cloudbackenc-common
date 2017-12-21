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
* Created by irotsoma on 6/19/2016.
*/
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import com.irotsoma.cloudbackenc.common.CloudBackEncUser
import java.util.*


/**
 * Cloud Service Authentication Class
 *
 * Abstract class that should be implemented with logic for authorization flows for a cloud service extension.
 *
 * @author Justin Zak
 * @property factory An instance of the CloudServiceFactory holding this class
 * @property cloudServiceAuthenticationRefreshListener An instance of a CloudServiceAuthenticationRefreshListener to watch for authentication events.
 */

abstract class CloudServiceAuthenticationService(val extensionUuid: UUID)  {
    abstract var cloudServiceAuthenticationRefreshListener: CloudServiceAuthenticationRefreshListener?
    /**
     * Requests the login status
     * @param cloudServiceUser A CloudServiceUser object whose status is requested
     * @return True if user is currently logged in to the cloud service. Otherwise, false.
     */
    abstract fun isLoggedIn(cloudServiceUser: CloudServiceUser, cloudBackEncUser: CloudBackEncUser): Boolean
    /**
     * Requests the system to log into the cloud service.
     * @param cloudServiceUser A CloudServiceUser object with username and password for login as well as callback url if needed.
     * @param cloudBackEncUser Internal CloudBackEncUser that is attempting to login.  Used for persistent credential storage.
     * @return CloudServiceUser.STATE depending on the result of the login.
     */
    abstract fun login(cloudServiceUser: CloudServiceUser, cloudBackEncUser: CloudBackEncUser) : CloudServiceUser.STATE
    /**
     * Requests the system to log off the cloud service.
     * @param cloudServiceUser A CloudServiceUser object to log out of the cloud service.
     * @return Message returned from the cloud service if applicable.
     */
    abstract fun logout(cloudServiceUser: CloudServiceUser, cloudBackEncUser: CloudBackEncUser) : CloudServiceUser.STATE

}