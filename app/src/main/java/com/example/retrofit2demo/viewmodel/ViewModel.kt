package com.example.retrofit2demo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofit2demo.model.Users
import com.example.retrofit2demo.repository.Repository
import com.example.retrofit2demo.retrofitapi.APIUtilities
import com.example.retrofit2demo.retrofitapi.ApiInterface
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    val retrieveUsers: LiveData<Users>
    private val repository: Repository
    private val apiInterface: ApiInterface = APIUtilities.getAPIInstance().create(ApiInterface::class.java)

    init {
        repository = Repository(apiInterface)
        viewModelScope.launch {
            repository.getAllUsers()
        }
        retrieveUsers = repository.users
    }
}