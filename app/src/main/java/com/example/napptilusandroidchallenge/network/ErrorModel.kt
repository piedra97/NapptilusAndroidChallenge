package com.example.napptilusandroidchallenge.network

import java.io.IOException
import java.io.Serializable

class ErrorModel(
    val code: Code,
    val description: String,
) : IOException(), Serializable {

    enum class Code {
        UNKNOWN
    }

}
