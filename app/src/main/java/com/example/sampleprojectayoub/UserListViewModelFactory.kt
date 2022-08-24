package com.example.sampleprojectayoub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleprojectayoub.repository.MainRepository
import com.example.sampleprojectayoub.viewmodel.UserListViewModel

class UserListViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            UserListViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}