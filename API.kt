package com.example.myapplication13.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    // handling null values
    private val gson = GsonBuilder().serializeNulls().create()

    private val retrofit  = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService : APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}