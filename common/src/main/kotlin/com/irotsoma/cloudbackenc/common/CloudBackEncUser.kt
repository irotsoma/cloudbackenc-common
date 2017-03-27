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
 * Created by irotsoma on 10/6/16.
 */
package com.irotsoma.cloudbackenc.common

import java.io.Serializable

/**
 * An object to represent an internal user for authorization across services.
 *
 * Note: this object contains the plain text password for authorization operations across services.  If reusing this
 * object call the maskedPasswordInstance to remove the password in a manner that the system will recognize.
 *
 * @author Justin Zak
 * @property username The ID of the user.
 * @property password The password of the user.
 * @property email (Optional) The email address of the user.  Must be in a valid format if present.
 * @property enabled Boolean value indicating whether the user can currently access the system.  Default = true
 * @property roles A List of CloudBackEncRoles assigned to the user.
 */
class CloudBackEncUser(val username: String,
                       val password : String,
                       val email: String?,
                       val enabled: Boolean = true,
                       val roles : List<CloudBackEncRoles>) : Serializable{
    companion object{
        /**
         * The text that will replace the password when maskedPasswordInstance is called.
         */
        const val PASSWORD_MASKED = "PASSWORD_MASKED"
        const val serialVersionUID = 579846513196
    }

    /**
     * Used to get a version of the object with the password masked by the constant value PASSWORD_MASKED
     *
     * @author Justin Zak
     * @return Instance of CloudBackEncUser with the password masked by PASSWORD_MASKED.
     */
    fun maskedPasswordInstance(): CloudBackEncUser{
        return CloudBackEncUser(username, PASSWORD_MASKED, email, enabled,roles)
    }
}