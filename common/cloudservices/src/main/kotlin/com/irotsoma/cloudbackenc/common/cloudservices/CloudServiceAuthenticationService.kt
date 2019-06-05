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
* Created by irotsoma on 6/19/2016.
*/
package com.irotsoma.cloudbackenc.common.cloudservices

import com.irotsoma.cloudbackenc.common.CloudBackEncUser
import java.util.*


/**
 * Cloud Service Authentication Class
 *
 * Abstract class that should be implemented with logic for authorization flows for a cloud service extension.
 *
 * @author Justin Zak
 * @property extensionUuid The UUID of the current extension.
 * @property cloudServiceAuthenticationRefreshListener An instance of a CloudServiceAuthenticationRefreshListener to watch for authentication events.
 */

abstract class CloudServiceAuthenticationService(val extensionUuid: UUID)  {
    abstract var cloudServiceAuthenticationRefreshListener: CloudServiceAuthenticationRefreshListener?
    /**
     * Requests the login status
     * @param cloudServiceAuthenticationRequest A CloudServiceAuthenticationRequest object whose status is requested
     * @param cloudBackEncUser Internal CloudBackEncUser that is logged in.  Used for persistent credential storage.
     * @return True if user is currently logged in to the cloud service. Otherwise, false.
     */
    abstract fun isLoggedIn(cloudServiceAuthenticationRequest: CloudServiceAuthenticationRequest, cloudBackEncUser: CloudBackEncUser): Boolean
    /**
     * Requests the system to log into the cloud service.
     * @param cloudServiceAuthenticationRequest A CloudServiceAuthenticationRequest object with username and password for login as well as callback url if needed.
     * @param cloudBackEncUser Internal CloudBackEncUser that is attempting to login.  Used for persistent credential storage.
     * @return CloudServiceAuthenticationState depending on the result of the login and a URI if required by authorization flow.
     */
    abstract fun login(cloudServiceAuthenticationRequest: CloudServiceAuthenticationRequest, cloudBackEncUser: CloudBackEncUser) : CloudServiceAuthenticationResponse
    /**
     * Requests the system to log off the cloud service.
     * @param cloudServiceAuthenticationRequest A CloudServiceAuthenticationRequest object to log out of the cloud service.
     * @param cloudBackEncUser Internal CloudBackEncUser that is attempting to logout.  Used for persistent credential storage.
     * @return Message returned from the cloud service if applicable.
     */
    abstract fun logout(cloudServiceAuthenticationRequest: CloudServiceAuthenticationRequest, cloudBackEncUser: CloudBackEncUser) : CloudServiceAuthenticationResponse

}