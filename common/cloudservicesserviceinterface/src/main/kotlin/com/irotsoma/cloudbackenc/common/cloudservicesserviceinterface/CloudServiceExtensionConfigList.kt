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
 * Created by irotsoma on 7/12/2016.
 */
package com.irotsoma.cloudbackenc.common.cloudservicesserviceinterface

import java.io.Serializable
import java.util.*

/**
 * Object for passing a list of Cloud Service Extensions through a REST API
 *
 * @author Justin Zak
 */
class CloudServiceExtensionConfigList() : Serializable, ArrayList<CloudServiceExtensionConfig>() {
    companion object {
        const val serialVersionUID = 84685165165
    }
    constructor(arrayList: List<CloudServiceExtensionConfig>) : this(){
        for (extension in arrayList){
            this.add(extension)
        }
    }
}