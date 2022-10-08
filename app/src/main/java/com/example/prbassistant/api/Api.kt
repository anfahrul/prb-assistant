package com.example.prbassistant.api

import com.example.prbassistant.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {
    @GET("patient/{medicalNumber}")
    fun getPatient(@Path("medicalNumber") medicalNumber: String): Call<PatienProfile>

    @GET("pharmacy")
    fun getPharmacy(): Call<ArrayList<Pharmacy>>

    @GET("bookcontrol/123")
    fun getBooks(): Call<Books>

    @GET("bookcontrol/123")
    fun getProfile(): Call<PatienData>

    @GET("pharmacy/recipe?recipeId=123")
    fun getMedicineOnRecipe(): Call<Medicine>

    @GET("pharmacy/recipe?recipeId=123")
    fun getRecipe(): Call<Recipe>

    @GET("pharmacy/recipe?recipeId=123")
    fun getPharmacyOnRecipe(): Call<PharmacySelected>

    @Headers("Content-Type: application/json")
    @PUT("pharmacy/123")
    fun updatePharmacy(@Body pharmacy:RequestPharmacy): Call<String>
}