package com.example.napptilusandroidchallenge.network

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface OompaLoompaApiService {
    @GET("oompa-loompas")
    suspend fun getOompaLoompasData(): OompaLoompaResponse

    @GET("oompa-loompas/{id}")
    suspend fun getOompaLoompaDetails(@Path("id") id: Long): OompaLoompa
}
