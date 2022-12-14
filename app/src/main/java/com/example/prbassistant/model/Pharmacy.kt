package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pharmacy(
    @SerializedName("PharmacyId")
    var pharmacyId: Int = 0,
    @SerializedName("Name")
    var name: String = "",
    @SerializedName("Address")
    var address: String = "",
): Parcelable
