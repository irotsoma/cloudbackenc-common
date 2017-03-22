/*
 * Created by irotsoma on 11/30/16.
 */
package com.irotsoma.cloudbackenc.common

import java.io.Serializable


data class VersionedExtensionFactoryClass (
        val canonicalName: String,
        val version: Int
): Serializable {
    companion object{
        const val serialVersionUID = 246846816
    }
}