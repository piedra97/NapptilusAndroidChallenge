package com.example.napptilusandroidchallenge.repository

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.example.napptilusandroidchallenge.network.OompaLoompaApiDataSource
import com.example.napptilusandroidchallenge.network.Result

class OompaLoompasRepositoryImpl(
    private val oompaLoompaApiDataSource: OompaLoompaApiDataSource
) : OompaLoompasRepository {

    override suspend fun getOompaLoompasData(): Result<OompaLoompaResponse> =
        oompaLoompaApiDataSource.getOompaLoompasData()

    override suspend fun getOompaLoompaDetails(id: Long): Result<OompaLoompa> =
        oompaLoompaApiDataSource.getOompaLoompaDetails(id)

}