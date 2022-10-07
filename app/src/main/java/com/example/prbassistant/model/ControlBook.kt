package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ControlBook(
    @SerializedName("CheckDate")
    var dateCheck: String = "",
    @SerializedName("DoctorName")
    var doctorName: String = "",
    @SerializedName("MedicalStatus")
    var medicalStatus: String = "",
    @SerializedName("Note")
    var note: String = "",
): Parcelable
