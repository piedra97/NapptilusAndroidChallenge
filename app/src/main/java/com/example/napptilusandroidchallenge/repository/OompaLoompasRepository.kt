package com.example.napptilusandroidchallenge.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.napptilusandroidchallenge.database.OompaLoompaDatabase
import com.example.napptilusandroidchallenge.database.asDomainModel
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.asDatabaseModel
import com.example.napptilusandroidchallenge.network.OompaLoompaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OompaLoompasRepository(private val database: OompaLoompaDatabase) {

    suspend fun refreshOompaLoompas() {
        withContext(Dispatchers.IO) {
            val oompaLoompasListResponse =  OompaLoompaApi.retrofitService.getOompaLoompasData()
            database.oompaLoompaDao.insertAll(oompaLoompasListResponse.asDatabaseModel())
        }
    }

    val oompaLoompas: LiveData<List<OompaLoompa>> = Transformations.map(database.oompaLoompaDao.getOompaLoompas()) {
        it.asDomainModel()
    }
}