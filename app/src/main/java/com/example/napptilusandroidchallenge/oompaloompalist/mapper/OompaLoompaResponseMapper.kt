package com.example.napptilusandroidchallenge.oompaloompalist.mapper

import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.example.napptilusandroidchallenge.model.uimodels.OompaLoompaUIModel

class OompaLoompaResponseMapper {

    fun map(data: OompaLoompaResponse): List<OompaLoompaUIModel> =
        data.results.map { oompaLoompa ->
            OompaLoompaUIModel(
                id = oompaLoompa.id ?: -1,
                image = oompaLoompa.image,
                name = oompaLoompa.firstName,
                lastName = oompaLoompa.lastName,
                profession = oompaLoompa.profession
            )
        }
}