package com.example.napptilusandroidchallenge.oompaloompadetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.network.OompaLoompaApi
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus
import kotlinx.coroutines.launch
import java.lang.Exception

class OompaLoompaDetailViewModel(oompaLoompaId: Long) : ViewModel() {

    private val _response = MutableLiveData<OompaLoompa>()
    val response: LiveData<OompaLoompa>
        get() = _response

    private val _status = MutableLiveData<OompaLoompaApiStatus>()
    val status: LiveData<OompaLoompaApiStatus>
        get() = _status

    init {
        getOompaLoompaDetails(oompaLoompaId)
    }

    private fun getOompaLoompaDetails(oompaLoompaId: Long) {
        viewModelScope.launch {
            _status.value = OompaLoompaApiStatus.LOADING
            try {
                _response.value = OompaLoompaApi.retrofitService.getOompaLoompaDetails(oompaLoompaId)
                _status.value = OompaLoompaApiStatus.DONE
            } catch (e: Exception) {
                _status.value = OompaLoompaApiStatus.ERROR
                _response.value = null
            }
        }
    }
}