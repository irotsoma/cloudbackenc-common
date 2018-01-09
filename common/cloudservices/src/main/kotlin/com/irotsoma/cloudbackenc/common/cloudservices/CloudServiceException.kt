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
 * Created by irotsoma on 6/20/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservices

/**
 * Exception class for Cloud Service Implementations
 *
 * @author Justin Zak
 */
open class CloudServiceException : Exception{
    /**
     * Creates an instance with only a message.
     *
     * @param message Exception description.
     */
    constructor(message: String?) : super(message)
    /**
     * Creates an instance with a message and the Throwable that caused the exception.
     *
     * @param message Exception description.
     * @param cause The Throwable that caused the exception to occur.
     */
    constructor(message: String?, cause: Throwable) : super(message, cause)
    /**
     * Creates an instance with no specific message but include the Throwable that caused the exception.
     *
     * @param cause The Throwable that caused the exception to occur.
     */
    constructor(cause: Throwable) : super(cause)
}