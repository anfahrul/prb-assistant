package com.example.prbassistant.model

import com.google.gson.annotations.SerializedName

data class Medicine(
    @SerializedName("medicine")
    var drugs: ArrayList<Drug>
)
