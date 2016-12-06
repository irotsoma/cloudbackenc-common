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

package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

/**
 * Callback url object for cloud service authorization flows.
 *
 * This object allows the central controller caller (e.g. CloudBackEnc UI) to allow the central controller to provide a
 * url for the user to complete the authorization process for any service that requires user input to explicitly
 * authorize CloudBackEnc to access their account.  The central controller calling application must implement a rest
 * controller that accepts a POST with this object as the body.
 *
 * @author Justin Zak
 * @property uuid The UUID of the cloud service extension
 * @property authorizationURL The URL that the user must browse to in order to authorize the application to access their account
 */
data class CloudServiceCallbackURL(
        val uuid: String,
        val authorizationURL: String)