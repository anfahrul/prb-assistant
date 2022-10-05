package com.example.prbassistant.api

import com.example.prbassistant.model.ControlBook
import com.example.prbassistant.model.PatienProfile
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<ControlBook>>

    @GET("users/1")
    fun getProfile(): Call<PatienProfile>
}