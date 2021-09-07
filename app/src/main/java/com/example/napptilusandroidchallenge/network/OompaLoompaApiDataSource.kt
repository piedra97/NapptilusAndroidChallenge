package com.example.napptilusandroidchallenge.network

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse

interface OompaLoompaApiDataSource {

    suspend fun getOompaLoompasData(): Result<OompaLoompaResponse>

    suspend fun getOompaLoompaDetails(id: Long): Result<OompaLoompa>
}