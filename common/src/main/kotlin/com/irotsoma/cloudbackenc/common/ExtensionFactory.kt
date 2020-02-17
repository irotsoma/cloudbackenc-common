/*
 * Copyright (C) 2016-2020  Irotsoma, LLC
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

import java.util.*

/**
 * Base interface for the factory class of an extension of any type.
 *
 * @author Justin Zak
 * @property extensionUuid The UUID of the extension.
 * @property extensionName The human readable name of the extension.
 * @property extensionVersion The numerical release version of the extension.
 */
interface ExtensionFactory{
    val extensionUuid:UUID
    val extensionName:String
    val extensionVersion:Int
}