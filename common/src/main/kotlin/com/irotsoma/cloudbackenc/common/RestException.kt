/*
 * Copyright (C) 2017  Irotsoma, LLC
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
 * Created by irotsoma on 10/20/16.
 */
package com.irotsoma.cloudbackenc.common

/**
 * A custom [Exception] class used to return structured exception messages to the rest client.
 *
 * @author Justin Zak
 * @property type The predefined type of rest exception to generate.
 */
open class RestException : Exception {
    val type : RestExceptionExceptions
    companion object {
        /**
         * Serialization UID for the custom Exception type
         */
        private const val serialVersionUID : Long = 23452365685674564
    }
    /**
     * @param type The predefined type of rest exception to generate.
     */
    constructor(type : RestExceptionExceptions) : super(){
        this.type = type
    }
    /**
     * @param type The predefined type of rest exception to generate.
     * @param cause A Throwable representing the cause of the current exception.
     */
    constructor( type : RestExceptionExceptions, cause: Throwable) : super(cause){
        this.type = type
    }
}