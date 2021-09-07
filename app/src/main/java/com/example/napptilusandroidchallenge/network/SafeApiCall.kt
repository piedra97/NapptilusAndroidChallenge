package com.example.napptilusandroidchallenge.network

import java.lang.Exception

suspend fun <T> safeApiCall(
    call: suspend () -> T
): Result<T> =
    try {
        val response = call()

        if (response == null) {
            Failure(DefaultError.getDefaultErrorModel())
        } else {
            Success(response)
        }
    } catch (exception: Exception) {
        if (exception is ErrorModel) {
            Failure(exception)
        } else {
            Failure(DefaultError.getDefaultErrorModel())
        }
    }
