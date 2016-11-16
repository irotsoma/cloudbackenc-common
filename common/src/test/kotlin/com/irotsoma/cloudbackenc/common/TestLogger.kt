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

import org.junit.Test

/**
 * Created by irotsoma on 8/3/2016.
 *
 * Unit test for unwrapping companion class for logger implementation and validating logger can be created.
 */
class TestLogger {
    @Suppress("JAVA_CLASS_ON_COMPANION")
    companion object{
        val testValueWithUnwrapper: String? = unwrapCompanionClass(this.javaClass).name
        val testValueWithoutUnwrapper: String? = this.javaClass.name
        val LOG by logger()
    }
    val expectedWithUnwrapper = "com.irotsoma.cloudbackenc.common.TestLogger"
    val expectedWithouUnwrapper = "com.irotsoma.cloudbackenc.common.TestLogger\$Companion"
    @Test
    fun TestCompanionUnwrapper(){
        //test that unwrapper returns class without the companion object
        assert(testValueWithUnwrapper == expectedWithUnwrapper)
        //negative test that without wrapper you do get the companion
        assert(testValueWithoutUnwrapper == expectedWithouUnwrapper)
        //test that logger object is created without errors and has the correct class name
        assert(LOG.name == expectedWithUnwrapper)
    }
}