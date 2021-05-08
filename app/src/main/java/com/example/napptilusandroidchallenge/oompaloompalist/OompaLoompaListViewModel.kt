package com.example.napptilusandroidchallenge.oompaloompalist

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.napptilusandroidchallenge.database.getDataBase
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.network.OompaLoompaApi
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus
import com.example.napptilusandroidchallenge.repository.OompaLoompasRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class OompaLoompaListViewModel(application: Application) : ViewModel() {

    private val _navigateToOompaLoompaDetail = MutableLiveData<Long>()
    val navigateOompaLoompaDetail
        get() = _navigateToOompaLoompaDetail

    private val _status = MutableLiveData<OompaLoompaApiStatus>()
    val status: LiveData<OompaLoompaApiStatus>
        get() = _status

    private val oompaLoompasRepository = OompaLoompasRepository(getDataBase(application))

    val response = oompaLoompasRepository.oompaLoompas

    init {
        getOompaLoompaData()
    }

    fun getOompaLoompaData() {
        viewModelScope.launch {
            _status.value = OompaLoompaApiStatus.LOADING
            try {
                oompaLoompasRepository.refreshOompaLoompas()
                _status.value = OompaLoompaApiStatus.DONE
            } catch (e: Exception) {
                _status.value = OompaLoompaApiStatus.ERROR
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