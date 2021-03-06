package com.example.napptilusandroidchallenge.repository

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.example.napptilusandroidchallenge.network.Result


interface OompaLoompasRepository {

    suspend fun getOompaLoompasData(): Result<OompaLoompaResponse>

    suspend fun getOompaLoompaDetails(id: Long): Result<OompaLoompa>

}