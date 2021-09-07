package com.example.napptilusandroidchallenge.oompaloompalist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.example.napptilusandroidchallenge.model.uimodels.OompaLoompaUIModel
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus
import com.example.napptilusandroidchallenge.network.either
import com.example.napptilusandroidchallenge.oompaloompalist.mapper.OompaLoompaResponseMapper
import com.example.napptilusandroidchallenge.usecases.GetOompaLoompaDataUseCase
import kotlinx.coroutines.launch

class OompaLoompaListViewModel(
    private val getOompaLoompaDataUseCase: GetOompaLoompaDataUseCase
) : ViewModel() {

    private val _navigateToOompaLoompaDetail = MutableLiveData<Long>()
    val navigateOompaLoompaDetail
        get() = _navigateToOompaLoompaDetail

    private val _status = MutableLiveData<OompaLoompaApiStatus>()
    val status: LiveData<OompaLoompaApiStatus>
        get() = _status

    private val _response = MutableLiveData<List<OompaLoompaUIModel>>()
    val response: LiveData<List<OompaLoompaUIModel>>
        get() = _response

    private val mapper = OompaLoompaResponseMapper()

    init {
        getOompaLoompaData()
    }

    fun getOompaLoompaData() {
        viewModelScope.launch {
            _status.value = OompaLoompaApiStatus.LOADING
            getOompaLoompaDataUseCase().either(
                onSuccess = { oompaLoompaResponse ->
                    _status.value = OompaLoompaApiStatus.DONE
                    _response.value = mapOompaLoompaResponse(oompaLoompaResponse)
                },
                onFailure = { _status.value = OompaLoompaApiStatus.ERROR }
            )
        }
    }

    private fun mapOompaLoompaResponse(oompaLoompaResponse: OompaLoompaResponse): List<OompaLoompaUIModel>? =
        mapper.map(oompaLoompaResponse)


    fun onOompaLoompaClicked(id: Long) {
        _navigateToOompaLoompaDetail.value = id
    }

    fun onOompaLoompaDetailNavigated() {
        _navigateToOompaLoompaDetail.value = null
    }


}