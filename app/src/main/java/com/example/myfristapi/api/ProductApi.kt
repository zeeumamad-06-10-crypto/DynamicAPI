package com.example.myfristapi.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductApi {

    // Full dynamic URL
    @GET
    fun getProducts(@Url url: String): Call<List<ProductItem>>
}
