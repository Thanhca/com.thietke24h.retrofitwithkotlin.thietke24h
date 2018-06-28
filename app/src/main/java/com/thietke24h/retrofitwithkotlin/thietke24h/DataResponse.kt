package com.thietke24h.retrofitwithkotlin.thietke24h

import com.google.gson.annotations.SerializedName

/**
 * Created by welcome on 6/28/2018.
 */
class DataResponse {

    @SerializedName("status")
    var status: Boolean = false

    @SerializedName("data")
    var data: String? = null


}