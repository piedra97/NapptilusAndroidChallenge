package com.example.napptilusandroidchallenge.network

sealed class Result<out T>
class Success<T>(val result: T) : Result<T>()
class Failure(val error: ErrorModel) : Result<Nothing>()

inline fun <T> Result<T>.either(onSuccess: (T) -> Unit, onFailure: (ErrorModel) -> Unit): Unit =
    when (this) {
        is Success -> {
            onSuccess.invoke(this.result)
        }
        is Failure -> {
            onFailure.invoke(this.error)
        }
    }

