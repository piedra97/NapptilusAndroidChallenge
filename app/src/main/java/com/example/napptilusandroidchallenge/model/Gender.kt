package com.example.napptilusandroidchallenge.model

import com.squareup.moshi.Json

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
