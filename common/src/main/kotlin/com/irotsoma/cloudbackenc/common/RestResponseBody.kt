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
 * Created by irotsoma on 11/18/2019.
 */
package com.irotsoma.cloudbackenc.common

import java.io.Serializable

/**
 * A response class for rest calls that allows for sending various types or sending a RestException object and allowing deserialization either way.
 */
class RestResponseBody<T>(var body: T) : Serializable {
    /** Companion Object to hold the static constants */
    companion object{
        /** UID for this class for java's Serializable object */
        const val serialVersionUID = 891561687489
    }
    var restException:RestExceptionExceptions? = null
    init {
        if(body is RestExceptionExceptions){
            restException = body as RestExceptionExceptions
        }
    }
}