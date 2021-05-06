package com.example.napptilusandroidchallenge.oompaloompadetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OompaLoompaDetailViewModelFactory(private val oompaLoompaId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OompaLoompaDetailViewModel::class.java)) {
            return OompaLoompaDetailViewModel(oompaLoompaId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}