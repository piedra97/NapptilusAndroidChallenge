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

data class OompaLoompa (
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    @Json(name = "favorite")
    val favorite: Favorite,
    @Json(name = "gender")
    val gender: Gender,
    @Json(name = "image")
    val image: String,
    @Json(name = "profession")
    val profession: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "age")
    val age: Long,
    @Json(name = "country")
    val country: String,
    @Json(name = "height")
    val height: Long,
    @Json(name = "id")
    val id: Long?
)

data class Favorite (
    @Json(name = "color")
    val color: String,
    @Json(name = "food")
    val food: String,
)

enum class Gender(val letter: String) {
    @Json(name = "F")
    Female("F"),
    @Json(name = "M")
    Male("M")
}

