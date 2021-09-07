package com.example.napptilusandroidchallenge.model

import com.squareup.moshi.Json


data class OompaLoompaResponse (
    @Json(name = "current")
    val current: Long,
    @Json(name = "total")
    val total: Long,
    @Json(name = "results")
    val results: List<OompaLoompa>
)
