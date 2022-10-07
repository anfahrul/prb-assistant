package com.example.prbassistant.model

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("recipeId")
    var recipeId: Int = 0,
    @SerializedName("claimStatus")
    var claimStatus: String = "",
)
