package com.example.retrofit2demo.retrofitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIUtilities {
    private const val BASE_URL = "https://reqres.in/"

    fun getAPIInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}