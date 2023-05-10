/*
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sample.yogiraj.instagram.demo.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Request Data Class for the "Update My Info API".
 *
 * @
 */
data class UpdateMyInfoRequest(
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("profilePicUrl")
    val profilePicUrl: String?,

    @Expose
    @SerializedName("tagline")
    val tagline: String?
)