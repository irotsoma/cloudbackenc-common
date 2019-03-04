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
 * Created by irotsoma on 11/30/16.
 */
package com.irotsoma.cloudbackenc.common

import java.io.Serializable

/**
 * Used by extension repositories to store references to installed extensions and pass those through REST services.
 *
 * @author Justin Zak
 * @property canonicalName Name of the extension to be viewed by humans.
 * @property version Version of the extension.
 */
data class VersionedExtensionFactoryClass (
        val canonicalName: String,
        val version: Int
    ): Serializable {
    /** Companion Object to hold the serialVersionUID */
    companion object{
        /** UID for this class for java's Serializable object */
        const val serialVersionUID = 246846816
    }
}