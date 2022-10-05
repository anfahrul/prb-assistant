package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ControlBook(
    @SerializedName("userId")
    var dateCheck: String = "",
    @SerializedName("id")
    var doctorName: String = "",
    @SerializedName("title")
    var medicalStatus: String = "",
    @SerializedName("body")
    var note: String = "",
): Parcelable
