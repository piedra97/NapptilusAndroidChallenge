package com.example.napptilusandroidchallenge.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.napptilusandroidchallenge.model.Favorite
import com.example.napptilusandroidchallenge.model.Gender
import com.example.napptilusandroidchallenge.model.OompaLoompa

@Entity
data class DataBaseOompaLoompa(
    @PrimaryKey
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val profession: String,
    val imageUrl: String,
    val genderLetter: String,
    val age: Long,
    val country: String,
    val email: String,
    val favoriteFood: String,
    val favoriteColor: String,
    val height: Long
)

fun List<DataBaseOompaLoompa>.asDomainModel(): List<OompaLoompa> {
    return map {
        OompaLoompa(
            id = it.id,
            firstName = it.firstName,
            lastName = it.lastName,
            profession = it.profession,
            image = it.imageUrl,
            gender = Gender.getGenderByLetter(it.genderLetter),
            age = it.age,
            country = it.country,
            email = it.email,
            favorite = Favorite(it.favoriteColor, it.favoriteFood),
            height = it.height
        )
    }
}

