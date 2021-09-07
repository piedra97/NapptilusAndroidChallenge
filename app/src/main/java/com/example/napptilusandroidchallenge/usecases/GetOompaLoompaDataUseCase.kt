package com.example.napptilusandroidchallenge.usecases

import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.example.napptilusandroidchallenge.network.Result
import com.example.napptilusandroidchallenge.repository.OompaLoompasRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetOompaLoompaDataUseCase(
    private val oompaLoompaRespository: OompaLoompasRepository
) {

    suspend operator fun invoke(): Result<OompaLoompaResponse> = withContext(Dispatchers.IO) {
        oompaLoompaRespository.getOompaLoompasData()
    }
}