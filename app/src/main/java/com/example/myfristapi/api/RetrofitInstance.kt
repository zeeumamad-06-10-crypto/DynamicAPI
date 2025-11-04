package com.example.myfristapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // Since Retrofit needs a baseUrl, we use a dummy base
    fun getApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl("https://dummy.com/") // dummy, not used if full URL passed
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }
}
