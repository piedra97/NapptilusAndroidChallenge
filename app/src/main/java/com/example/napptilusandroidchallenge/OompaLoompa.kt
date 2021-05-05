package com.example.napptilusandroidchallenge


data class OompaLoompa (
    val firstName: String,
    val lastName: String,
    val favorite: Favorite,
    val gender: Gender,
    val image: String,
    val profession: String,
    val email: String,
    val age: Long,
    val country: String,
    val height: Long,
    val id: Long
)

data class Favorite (
    val color: String,
    val food: String,
    val song: String
)

enum class Gender(val letter: String) {
    Female("F"),
    Male("M")
}

