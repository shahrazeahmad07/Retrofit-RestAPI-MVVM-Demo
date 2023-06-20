package com.example.retrofit2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2demo.adapters.UsersRvAdapter
import com.example.retrofit2demo.databinding.ActivityMainBinding
import com.example.retrofit2demo.model.Data
import com.example.retrofit2demo.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var usersRvAdapter: UsersRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //! recycler view
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)

        //! Setting View Model
        val viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[ViewModel::class.java]


        //! retrieving Users
        viewModel.retrieveUsers.observe(this){list ->
            showAllUsers(list.data)
        }
    }

    //! showing all users
    private fun showAllUsers(list: List<Data>?) {
        if (list?.isNotEmpty()!!) {
            binding.usersRecyclerView.visibility = View.VISIBLE
            binding.tvNoRecords.visibility = View.GONE
            usersRvAdapter = UsersRvAdapter(list)
            binding.usersRecyclerView.adapter = usersRvAdapter
        } else {
            binding.usersRecyclerView.visibility = View.GONE
            binding.tvNoRecords.visibility = View.VISIBLE
        }
    }
}