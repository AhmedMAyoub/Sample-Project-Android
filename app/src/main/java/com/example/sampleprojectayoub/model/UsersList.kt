package com.example.sampleprojectayoub.model

import com.google.gson.annotations.SerializedName

data class UsersList(@SerializedName("items") val uList : List<User>)