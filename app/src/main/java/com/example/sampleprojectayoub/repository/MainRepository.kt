package com.example.sampleprojectayoub.repository

import com.example.sampleprojectayoub.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllUsers (username : String) = retrofitService.getAllUsers(username)

    fun getMoreUsers(username: String, pagenumber : Int) = retrofitService.getMoreUsers(username, pagenumber)
}