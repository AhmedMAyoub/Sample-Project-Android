package com.example.sampleprojectayoub.repository

import com.example.sampleprojectayoub.RetrofitService
import retrofit2.http.Query

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllUsers (@Query("q") username : String) = retrofitService.getAllUsers(username)
}