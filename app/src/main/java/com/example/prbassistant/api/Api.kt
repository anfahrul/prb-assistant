package com.example.prbassistant.api

import com.example.prbassistant.model.*
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("pharmacy")
    fun getPharmacy(): Call<ArrayList<Pharmacy>>

    @GET("bookcontrol/4")
    fun getBooks(): Call<Books>

    @GET("bookcontrol/4")
    fun getProfile(): Call<PatienData>

    @GET("pharmacy/recipe?recipeId=1")
    fun getMedicineOnRecipe(): Call<Medicine>

    @GET("pharmacy/recipe?recipeId=1")
    fun getRecipe(): Call<Recipe>

    @GET("pharmacy/recipe?recipeId=1")
    fun getPharmacyOnRecipe(): Call<PharmacySelected>
}