package com.example.napptilusandroidchallenge.model

import com.example.napptilusandroidchallenge.database.DataBaseOompaLoompa
import com.squareup.moshi.Json


data class OompaLoompaResponse (
    @Json(name = "current")
    val current: Long,
    @Json(name = "total")
    val total: Long,
    @Json(name = "results")
    val results: List<OompaLoompa>
)

fun OompaLoompaResponse.asDatabaseModel(): List<DataBaseOompaLoompa> {
    return results.map {
        DataBaseOompaLoompa(
            id = it.id,
            firstName = it.firstName,
            lastName = it.lastName,
            profession = it.profession,
            imageUrl = it.image,
            genderLetter = it.gender.letter,
            age = it.age,
            country = it.country,
            email = it.email,
            favoriteColor = it.favorite.color,
            favoriteFood = it.favorite.food,
            height = it.height
        )
    }
}

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
    Male("M");

    companion object {
        fun getGenderByLetter(letter: String) = when (letter) {
            "F" -> Female
            "M" -> Male
            else -> Female
        }
    }
}

