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
* Created by irotsoma on 6/19/2016.
**/
package com.irotsoma.cloudbackenc.common.cloudservice

import com.irotsoma.cloudbackenc.common.CloudBackEncUser

/**
 * Cloud Service Authentication Interface
 *
 * Interface that should be implemented with logic for authorization flows for a cloud service extension.
 *
 * @author Justin Zak
 */

interface CloudServiceAuthenticationService  {

    /**
     * Requests the login status
     * @param user A [CloudServiceUser] object whose status is requested
     * @return True if user is currently logged in to the cloud service. Otherwise, false.
     */
    fun isLoggedIn(user: CloudServiceUser): Boolean
    /**
     * Requests the system to log into the cloud service.
     * @param user Internal CloudBackEncUser that is attempting to login.  Used for persistent credential storage.
     * @param cloudServiceUser A [CloudServiceUser] object with username and password for login as well as callback url if needed.
     * @return [CloudServiceUser.STATE] depending on the result of the login.
     */
    fun login(user: CloudBackEncUser, cloudServiceUser: CloudServiceUser) : CloudServiceUser.STATE
    /**
     * Requests the system to log off the cloud service.
     * @param user A [CloudServiceUser] object to log out of the cloud service.
     * @return Message returned from the cloud service if applicable.
     */
    fun logoff(user: CloudServiceUser) : CloudServiceUser.STATE
}