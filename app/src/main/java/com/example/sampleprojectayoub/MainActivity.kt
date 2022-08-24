package com.example.sampleprojectayoub

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sampleprojectayoub.databinding.ActivityMainBinding
import com.example.sampleprojectayoub.repository.MainRepository
import com.example.sampleprojectayoub.viewmodel.UserListViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: UserListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get viewmodel instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, UserListViewModelFactory(MainRepository(retrofitService))).get(
                UserListViewModel::class.java
            )

        //set recyclerview adapter
        binding.recyclerview.adapter = adapter

        viewModel.userList.observe(this, Observer {
            Log.d(TAG, "userList: $it")
            adapter.setUsersList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        val searchview = binding.searchView
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.getAllUsers(p0)
                return false
            }

            override fun onQueryTextChange(p0: String): Boolean {
                return false
            }

        })
    }
}