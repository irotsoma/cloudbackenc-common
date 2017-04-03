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
 * Created by irotsoma on 2/1/17.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import com.irotsoma.cloudbackenc.common.CloudBackEncUser
import java.util.*

/**
 * Interface for creating a listener for authentication events from a cloud service.
 *
 * @author Justin Zak
 */
interface CloudServiceAuthenticationRefreshListener{
    /**
     * Internal user associated with the listener.
     */
    var user:CloudBackEncUser?
    /**
     * Username or other unique ID of the user at the cloud service.
     */
    var cloudServiceUsername: String?
    /**
     * Implement to receive authentication change events
     *
     * @param cloudServiceUuid UUID of the cloud service associated with this listener.
     * @param newState The new authentication state.
     */
    fun onChange(cloudServiceUuid: UUID, newState: CloudServiceUser.STATE)
}