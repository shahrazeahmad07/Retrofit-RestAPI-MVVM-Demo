package com.example.retrofit2demo.retrofitapi

import com.example.retrofit2demo.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/users?page=2")
    suspend fun getUsers(): Response<Users>
}