package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PatienProfile(
    @SerializedName("name")
    var name: String = "",
    @SerializedName("username")
    var medicalRecordNumber: String = "",
    @SerializedName("email")
    var hospital: String = "",
    @SerializedName("phone")
    var diagnosis: String = "",
    @SerializedName("website")
    var BPJSNumber: String = "",
    @SerializedName("street")
    var birthDate: String = "",
    @SerializedName("suite")
    var address: String = "",
    @SerializedName("city")
    var phoneNumber: String = "",
): Parcelable
