package com.example.napptilusandroidchallenge.oompaloompalist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OompaLoompaListViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OompaLoompaListViewModel::class.java)) {
            return OompaLoompaListViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}