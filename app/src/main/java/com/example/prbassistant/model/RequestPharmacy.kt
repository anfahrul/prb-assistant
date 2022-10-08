package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RequestPharmacy(
    @SerializedName("claimStatus")
    var claimStatus: String = "Diklaim",
    @SerializedName("pharmacyId")
    var pharmacyId: Int = 0,
): Parcelable
