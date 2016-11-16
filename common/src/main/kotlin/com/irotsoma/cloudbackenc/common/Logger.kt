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

package com.irotsoma.cloudbackenc.common

import kotlin.reflect.companionObject

/*
 * Created by irotsoma on 7/8/2016.
 * Logging functionality
 * from example: https://stackoverflow.com/questions/34416869/idiomatic-way-of-logging-in-kotlin
 */

/**
 * Logger
 *
 * usage: companion object { val LOG by logger() }
 *
 * @author Justin Zak
 * @return instance of a log4j logger
 */
fun <R : Any> R.logger(): Lazy<org.apache.log4j.Logger> {
    return lazy { org.apache.log4j.Logger.getLogger(unwrapCompanionClass(this.javaClass).name)}
}

/**
 * Unwraps a companion object so it can reference the enclosing class.
 *
 * @author Justin Zak
 * @param ofClass Class to be unwrapped
 * @return Unwrapped, enclosing class of the companion object
 */
fun <T: Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> {
    return if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.companionObject?.java == ofClass) {
        ofClass.enclosingClass
    } else {
        ofClass
    }
}