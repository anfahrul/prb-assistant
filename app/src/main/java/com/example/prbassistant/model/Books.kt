package com.example.prbassistant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Books(
    @SerializedName("books")
    var books: ArrayList<ControlBook>

): Parcelable
