package com.example.prbassistant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MedicineReminder(
    var name: String = "",
    var repetionOnceDay: String = "",
    var time: String = "",
    var repetion: String = "",
): Parcelable
