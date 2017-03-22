/*
 * Created by irotsoma on 12/6/16.
 */

package com.irotsoma.cloudbackenc.common

import java.io.Serializable
import java.util.*

data class FileMetadata(
        val senderId: UUID,
        val senderFileId: UUID
): Serializable {
    companion object{
        const val serialVersionUID = 894651894854
    }
}