package com.example.sampleprojectayoub.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleprojectayoub.model.User
import com.example.sampleprojectayoub.model.UsersList
import com.example.sampleprojectayoub.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class UserListViewModel(private val repository: MainRepository) : ViewModel() {

    val userList = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUsers(@Query("q") username : String) {
        val response = repository.getAllUsers(username)
        response.enqueue(object : Callback<UsersList> {
            override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {
                userList.postValue(response.body()?.uList)
            }

            override fun onFailure(call: Call<UsersList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}