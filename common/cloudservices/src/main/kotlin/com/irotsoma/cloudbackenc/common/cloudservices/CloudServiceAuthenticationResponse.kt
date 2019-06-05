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
 * Created by irotsoma on 5/31/2019.
 */
package com.irotsoma.cloudbackenc.common.cloudservices

import java.net.URI

/**
 * Class used for responding to a cloud service authentication request
 *
 * @property cloudServiceAuthenticationState The state of the login process.
 * @property cloudServiceAuthenticationUri A URI for continuing the login process if required by the authorization flow.
 * @author Justin Zak
 */
data class CloudServiceAuthenticationResponse(val cloudServiceAuthenticationState: CloudServiceAuthenticationState,
                                         val cloudServiceAuthenticationUri: URI? = null
)