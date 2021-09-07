package com.example.napptilusandroidchallenge.usecases

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.network.Result
import com.example.napptilusandroidchallenge.repository.OompaLoompasRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetOompaLoompaDetailsUseCase(
    private val oompaLoompaRespository: OompaLoompasRepository
) {

    suspend operator fun invoke(id: Long): Result<OompaLoompa> = withContext(Dispatchers.IO) {
        oompaLoompaRespository.getOompaLoompaDetails(id)
    }
}