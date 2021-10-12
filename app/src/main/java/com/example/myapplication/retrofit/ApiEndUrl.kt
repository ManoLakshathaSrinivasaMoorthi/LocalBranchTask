package com.example.myapplication.retrofit

import com.example.myapplication.model.FoodModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndUrl {
    @GET("recipes.json")
    suspend fun getFoods(): Response<FoodModel>
}