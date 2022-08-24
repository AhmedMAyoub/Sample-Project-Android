package com.example.sampleprojectayoub.repository

import com.example.sampleprojectayoub.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllUsers () = retrofitService.getAllUsers()
}