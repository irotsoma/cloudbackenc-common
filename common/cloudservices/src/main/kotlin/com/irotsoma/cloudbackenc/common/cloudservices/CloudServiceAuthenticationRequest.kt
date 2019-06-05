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
 * Created by irotsoma on 7/13/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservices

/**
 * Object representing a cloud service user for APIs
 *
 * @author Justin Zak
 * @property username User ID for the service
 * @property password Password for the service (only for login, and only if the service has no external authorization page, should be null otherwise)
 * @property extensionUuid UUID for the cloud service extension.  Defined by the extension author as part of a cloud-service-extension.json file under resources.
 * @property authorizationCallbackURL Use only if state = AWAITING_AUTHORIZATION.  A browser with this URL should be opened for the user to authorize the service.
 * @property replyWithAuthorizationUrl Set to true if the controller should respond immediately with an authorization url if used by the cloud service rather than sending it through the authorizationCallbackURL.
 */
data class CloudServiceAuthenticationRequest(
        val username: String,
        //TODO: Store password as a sealed object or similar
        val password:String?,
        val extensionUuid: String,
        val authorizationCallbackURL: String?,
        val replyWithAuthorizationUrl: Boolean = false
        )