package com.example.prbassistant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pharmacy(
    var name: String = "",
    var address: String = "",
): Parcelable
