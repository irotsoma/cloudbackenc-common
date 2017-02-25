/**
 * Created by irotsoma on 2/1/17.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import com.irotsoma.cloudbackenc.common.CloudBackEncUser
import java.util.*

/**
 *
 *
 * @author Justin Zak
 */
interface CloudServiceAuthenticationRefreshListener{
    var user:CloudBackEncUser
    fun onChange(cloudServiceUuid: UUID, newState: CloudServiceUser.STATE)
}