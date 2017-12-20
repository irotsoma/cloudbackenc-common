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
 * Created by irotsoma on 8/18/2016.
 */
package com.irotsoma.cloudbackenc.common.encryptionserviceinterface

import com.irotsoma.cloudbackenc.common.Extension
import java.util.*

/**
 * Encryption Service Extension Object
 *
 * @author Justin Zak
 */
class EncryptionServiceExtension: Extension {
    companion object{
        const val serialVersionUID = 955147875125
    }
    /**
     * Initialize the extension with a random UUID and no name
     */
    constructor():super(UUID.randomUUID(),"")
    /**
     * Initialize the extension object with the uuid and name of the extension
     */
    constructor(uuid: UUID, name: String):super(uuid,name){
        this.uuid = uuid
        this.name = name
    }
}
