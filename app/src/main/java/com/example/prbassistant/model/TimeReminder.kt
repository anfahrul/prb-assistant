package com.example.prbassistant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TimeReminder(
    var time: String = ""
): Parcelable
