package com.example.napptilusandroidchallenge.oompaloompalist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.network.OompaLoompaApi
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus
import kotlinx.coroutines.launch
import java.lang.Exception

class OompaLoompaListViewModel : ViewModel() {

    private val _navigateToOompaLoompaDetail = MutableLiveData<Long>()
    val navigateOompaLoompaDetail
        get() = _navigateToOompaLoompaDetail

    private val _response = MutableLiveData<List<OompaLoompa>>()
    val response: LiveData<List<OompaLoompa>>
        get() = _response

    private val _status = MutableLiveData<OompaLoompaApiStatus>()
    val status: LiveData<OompaLoompaApiStatus>
        get() = _status

    init {
        getOompaLoompaData()
    }

    fun getOompaLoompaData() {
        viewModelScope.launch {
            _status.value = OompaLoompaApiStatus.LOADING
            try {
                _response.value = OompaLoompaApi.retrofitService.getOompaLoompasData().results
                _status.value = OompaLoompaApiStatus.DONE
            } catch (e: Exception) {
                _status.value = OompaLoompaApiStatus.ERROR
                _response.value = ArrayList()
            }
        }
    }

    fun onOompaLoompaClicked(id: Long) {
        _navigateToOompaLoompaDetail.value = id
    }

    fun onOompaLoompaDetailNavigated() {
        _navigateToOompaLoompaDetail.value = null
    }


}