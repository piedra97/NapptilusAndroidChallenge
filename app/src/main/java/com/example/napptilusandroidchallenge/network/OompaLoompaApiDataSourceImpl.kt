package com.example.napptilusandroidchallenge.network

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse


class OompaLoompaApiDataSourceImpl(
    netWorkClient: NetworkClient
) : OompaLoompaApiDataSource {

    private val service: OompaLoompaApiService =
        netWorkClient.retrofitService

    override suspend fun getOompaLoompasData(): Result<OompaLoompaResponse> =
        safeApiCall {
            service.getOompaLoompasData()
        }

    override suspend fun getOompaLoompaDetails(id: Long): Result<OompaLoompa> =
        safeApiCall {
            service.getOompaLoompaDetails(id)
        }

}