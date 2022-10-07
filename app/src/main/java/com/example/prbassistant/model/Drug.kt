package com.example.prbassistant.model

import com.google.gson.annotations.SerializedName

data class Drug(
    @SerializedName("Name")
    var name: String = "",
    @SerializedName("Quantity")
    var amount: Int = 0,
    @SerializedName("Portion")
    var portion: Int = 0
)
