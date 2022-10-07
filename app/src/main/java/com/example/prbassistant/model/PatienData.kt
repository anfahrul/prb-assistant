package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PatienData(
    @SerializedName("patientData")
    var patientProfile: PatienProfile
): Parcelable
