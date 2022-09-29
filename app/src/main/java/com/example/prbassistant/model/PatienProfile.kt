package com.example.prbassistant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PatienProfile(
    var name: String = "",
    var medicalRecordNumber: String = "",
    var hospital: String = "",
    var diagnosis: String = "",
    var BPJSNumber: String = "",
    var birthDate: String = "",
    var address: String = "",
    var phoneNumber: String = "",
): Parcelable
