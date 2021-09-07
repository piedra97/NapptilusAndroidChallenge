package com.example.napptilusandroidchallenge.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class NetworkClient {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(DEFAULT_BASE_URL)
        .build()

        val retrofitService : OompaLoompaApiService by lazy {
            retrofit.create(OompaLoompaApiService::class.java) }

    companion object {
        private const val DEFAULT_BASE_URL = "https://2q2woep105.execute-api.eu-west-1.amazonaws.com/napptilus/"
    }

}

