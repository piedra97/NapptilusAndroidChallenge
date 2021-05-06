package com.example.napptilusandroidchallenge.network

import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.OompaLoompaResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://2q2woep105.execute-api.eu-west-1.amazonaws.com/napptilus/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface OompaLoompaApiService {
    @GET("oompa-loompas")
    suspend fun getOompaLoompasData(): OompaLoompaResponse
}

object OompaLoompaApi {
    val retrofitService : OompaLoompaApiService by lazy {
        retrofit.create(OompaLoompaApiService::class.java) }
}
