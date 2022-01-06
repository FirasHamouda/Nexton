package com.nexton.nextonprojet.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nexton.nextonprojet.data.api.ApiHelper
import com.nexton.nextonprojet.data.repository.MainRepository
import com.nexton.nextonprojet.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}