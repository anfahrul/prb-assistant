package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PatienProfile(
    @SerializedName("Name")
    var name: String = "",
    @SerializedName("MedicalRecord")
    var medicalRecordNumber: String = "",
    @SerializedName("Hospital")
    var hospital: String = "",
    @SerializedName("Diagnosis")
    var diagnosis: String = "",
    @SerializedName("BpjsNumber")
    var BPJSNumber: String = "",
    @SerializedName("Bithdate")
    var birthDate: String = "",
    @SerializedName("Address")
    var address: String = "",
    @SerializedName("PhoneNumber")
    var phoneNumber: String = "",
): Parcelable
