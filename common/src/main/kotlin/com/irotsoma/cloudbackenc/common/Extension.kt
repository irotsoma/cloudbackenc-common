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

package com.irotsoma.cloudbackenc.common

import java.io.Serializable
import java.util.*
import kotlin.reflect.KClass

open class Extension(val uuid:UUID, val name:String, val version:Int): Serializable {
    companion object{
        const val serialVersionUID = 41891687891
    }

    /**
     * Determines if two instances of Extension are equal by comparing the uuid and name.  Both must be the
     * same.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is Extension){
            false
        } else {
            (other.uuid == this.uuid) && (other.name == this.name) && (other.version == this.version)
        }
    }

    /**
     * Generates a hash code based on the UUID, name, and version.
     */
    override fun hashCode(): Int {
        return uuid.hashCode() + name.hashCode() + version.hashCode()
    }
}