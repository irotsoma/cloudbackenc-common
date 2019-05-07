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

package com.irotsoma.cloudbackenc.common.cloudservices


import org.junit.Test
import java.util.*

class CloudServiceFactoryTest {
    val expectedUuid = UUID.fromString("5ed18eb3-a06c-4fa4-bb98-eebf5b2fa116")
    class CloudServiceFactoryImplementation : CloudServiceFactory(){
        override val authenticationService: CloudServiceAuthenticationService
            get() = throw Exception("This is a test class.")
        override val cloudServiceFileIOService: CloudServiceFileIOService
            get() = throw Exception("This is a test class.")
    }
    @Test
    fun test(){
        val original = CloudServiceFactoryImplementation()
        assert(original.extensionUuid == expectedUuid) //test loading of json file
        assert(original.additionalSettings.containsKey("testSetting"))
        val anotherInstance = CloudServiceFactoryImplementation()
        anotherInstance.token = "test" //test that token is not used for determining equality
        assert (original == anotherInstance) //test equality between instances
    }
}
