package com.example.napptilusandroidchallenge.network

object DefaultError {

    fun getDefaultErrorModel(description: String = ""): ErrorModel = ErrorModel(
        ErrorModel.Code.UNKNOWN,
        description
    )
}
