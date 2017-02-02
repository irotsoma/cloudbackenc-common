/**
 * Created by irotsoma on 2/1/17.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import com.irotsoma.cloudbackenc.common.CloudBackEncUser

/**
 *
 *
 * @author Justin Zak
 */
interface CloudServiceAuthenticationRefreshListener{
    var user:CloudBackEncUser?
    fun onChange(newState: CloudServiceUser.STATE)
}