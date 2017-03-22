/**
 * Created by irotsoma on 3/13/17.
 */
package com.irotsoma.cloudbackenc.common

import java.io.Serializable

/**
 *
 *
 * @author Justin Zak
 */
class AuthenticationToken(val token: String) : Serializable {
    companion object{
        const val serialVersionUID = 994165165
    }
}