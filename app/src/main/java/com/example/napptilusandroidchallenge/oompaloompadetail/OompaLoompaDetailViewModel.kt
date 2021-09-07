package com.example.napptilusandroidchallenge.oompaloompadetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus
import com.example.napptilusandroidchallenge.network.either
import com.example.napptilusandroidchallenge.usecases.GetOompaLoompaDetailsUseCase
import kotlinx.coroutines.launch

class OompaLoompaDetailViewModel(
    private val getOompaLoompaDetailsUseCase: GetOompaLoompaDetailsUseCase,
    oompaLoompaId: Long
) : ViewModel() {

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
            getOompaLoompaDetailsUseCase(oompaLoompaId).either(
                onSuccess = {oompaLoompa ->
                    _status.value = OompaLoompaApiStatus.DONE
                    _response.value = oompaLoompa
                },
                onFailure = {
                    _status.value = OompaLoompaApiStatus.ERROR
                    _response.value = null
                }
            )
        }
    }
}