package com.example.retrofit2demo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit2demo.model.Users
import com.example.retrofit2demo.retrofitapi.ApiInterface

class Repository(private val apiInterface: ApiInterface) {

    private val usersLiveData = MutableLiveData<Users>()

    val users: LiveData<Users>
        get() = usersLiveData

    suspend fun getAllUsers() {
        val result = apiInterface.getUsers()
        if (result.body() != null) {
            usersLiveData.postValue(result.body())
        }
    }
}