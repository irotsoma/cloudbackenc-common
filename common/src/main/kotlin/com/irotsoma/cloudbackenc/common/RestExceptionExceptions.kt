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
 * Created by irotsoma on 10/20/16.
 */
package com.irotsoma.cloudbackenc.common

import java.util.*

/**
 * An enum used to send more specific error messages than the status codes through a REST controller and allow for the receiving service to receive an internationalized version
 *
 * @author Justin Zak
 */
enum class RestExceptionExceptions {
    /**
     * Returned when attempting to create a user with a user ID that already exists.
     */
    Duplicate_User{
        override fun httpStatusCode(): Int{
            return 400
        }
    },
    /**
     * Returned when attempting to access a URL under /cloudservice with an invalid UUID.
     */
    Invalid_Cloud_Service_UUID{
        override fun httpStatusCode(): Int{
            return 404
        }
    },
    /**
     * Returned when attempting to access a URL under /file-encryptors with an invalid UUID.
     */
    Invalid_Encryption_Service_UUID{
        override fun httpStatusCode(): Int{
            return 404
        }
    },
    /**
     * Returned when attempting to access a URL under /users with an invalid user ID.
     */
    User_Not_Found{
        override fun httpStatusCode(): Int{
            return 404
        }
    },
    /**
     * Returned when the system can not find the file that needs to be processed based on the request.
     */
    File_Not_Found{
        override fun httpStatusCode(): Int{
            return 404
        }
    },
    /**
     * Returned when the requested encryption plugin does not support the requested encryption algorithm.
     */
    Unsupported_Encryption_Algorithm{
        override fun httpStatusCode(): Int{
            return 400
        }
    },
    /**
     * Returned when setting up a user with an email address that is not in the correct format.
     */
    Invalid_Email_Address{
        override fun httpStatusCode(): Int{
            return 400
        }
    },
    /**
     * Returned when the file could not be written to the disk.
     */
    File_Not_Writable{
        override fun httpStatusCode(): Int {
            return 400
        }
    }
    ;

    /**
     * Must be implemented for each enum and should return the HTTP error code as an integer.
     */
    abstract fun httpStatusCode(): Int
    /**
     * Generates the message associated with the Exception using the locale specified.
     *
     * The message must be part of the messages bundle.  Message keys should be in the format common.message.rest.exception. followed by the name of the enum value in lowercase and will all underscores converted to periods.
     * For example, the message for [Duplicate_User] is common.message.rest.exception.duplicate.user
     *
     * @return A locale specific (if available) user friendly message associated with the exception.
     */
    fun friendlyMessage(locale: Locale) : String {
        return ResourceBundle.getBundle("messages",locale).getString("common.message.rest.exception.${this.name.toLowerCase().replace('_','.')}")
    }
}