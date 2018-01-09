/*
 * Copyright (C) 2016-2018  Irotsoma, LLC
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
 * Created by irotsoma on 3/13/17.
 */
package com.irotsoma.cloudbackenc.common

import java.io.Serializable
import java.util.*

/**
 * Object used to serialize an authentication token through the authentication REST service
 * @property token A CloudBackEnc authentication token
 * @property tokenExpiration The expiration date/time of the token.
 * @author Justin Zak
 */
class AuthenticationToken(val token: String,
                          val tokenExpiration: Date?) : Serializable {
    /** Companion Object to hold the serialVersionUID */
    companion object{
        /** UID for this class for java's Serializable object */
        const val serialVersionUID = 994165165
    }
}