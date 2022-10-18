package com.example.prbassistant.api

import com.example.prbassistant.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {
    @GET("api/patient/{medicalNumber}")
    fun getPatient(@Path("medicalNumber") medicalNumber: String): Call<PatienProfile>

    @GET("api/pharmacy")
    fun getPharmacy(): Call<ArrayList<Pharmacy>>

    @GET("api/bookcontrol/{medicalNumber}")
    fun getBooks(@Path("medicalNumber") medicalNumber: String): Call<Books>

    @GET("api/bookcontrol/{medicalNumber}")
    fun getProfile(@Path("medicalNumber") medicalNumber: String): Call<PatienData>

    @GET("api/pharmacy/{medicalNumber}")
    fun getMedicineOnRecipe(@Path("medicalNumber") medicalNumber: String): Call<Medicine>

    @GET("api/pharmacy/{medicalNumber}")
    fun getRecipe(@Path("medicalNumber") medicalNumber: String): Call<Recipe>

    @GET("api/pharmacy/{medicalNumber}")
    fun getPharmacyOnRecipe(@Path("medicalNumber") medicalNumber: String): Call<PharmacySelected>

    @Headers("Content-Type: application/json")
    @PUT("api/pharmacy/{medicalNumber}")
    fun updatePharmacy(@Body pharmacy:RequestPharmacy, @Path("medicalNumber") medicalNumber: String): Call<String>
}