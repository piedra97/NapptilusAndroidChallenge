package com.example.napptilusandroidchallenge.oompaloompalist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.example.napptilusandroidchallenge.network.OompaLoompaApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class OompaLoompaListViewModel : ViewModel() {

    private val _navigateToOompaLoompaDetail = MutableLiveData<Long>()
    val navigateOompaLoompaDetail
        get() = _navigateToOompaLoompaDetail

    private val _response = MutableLiveData<List<OompaLoompa>>()
    val response: LiveData<List<OompaLoompa>>
        get() = _response

    init {
        getOompaLoompaData()
    }

    fun getOompaLoompaData() {
        viewModelScope.launch {
            try {
                val listResult = OompaLoompaApi.retrofitService.getOompaLoompasData()
                _response.value = listResult.
            } catch (e: Exception) {
                _response.value = "Failure: " + e.message
            }
        }
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