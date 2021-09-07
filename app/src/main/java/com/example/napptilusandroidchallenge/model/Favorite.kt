package com.example.napptilusandroidchallenge.model

import com.squareup.moshi.Json

data class Favorite (
    @Json(name = "color")
    val color: String,
    @Json(name = "food")
    val food: String,
)
