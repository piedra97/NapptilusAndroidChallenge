package com.example.napptilusandroidchallenge.oompaloompalist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OompaLoompaListViewModel : ViewModel() {

    private val _navigateToOompaLoompaDetail = MutableLiveData<Long>()
    val navigateOompaLoompaDetail
        get() = _navigateToOompaLoompaDetail

    init {

    }

    fun getOompaLoompaData() {
       //TODO: API Call to get oompa loompa data
    }

    fun onOompaLoompaClicked(id: Long) {
        _navigateToOompaLoompaDetail.value = id
    }

    fun onOompaLoompaDetailNavigated() {
        _navigateToOompaLoompaDetail.value = null
    }

    override fun onCleared() {
        super.onCleared()
    }

}