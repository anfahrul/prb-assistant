package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PharmacySelected(
    @SerializedName("pharmacy")
    var pharmacy: Pharmacy
): Parcelable
