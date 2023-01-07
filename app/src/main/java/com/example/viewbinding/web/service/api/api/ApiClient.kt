package com.example.viewbinding.web.service.api.api

import com.example.viewbinding.web.service.api.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private lateinit var retrofit: Retrofit

    private val client=OkHttpClient.Builder()
        .connectTimeout(60L,TimeUnit.SECONDS)
        .readTimeout(60L,TimeUnit.SECONDS)
        .writeTimeout(60L,TimeUnit.SECONDS)
        .build()

   fun getClient(): Retrofit{

       retrofit=Retrofit.Builder()
           .baseUrl(Const.BASE_URL)
           .client(client)
           .addConverterFactory(GsonConverterFactory.create())
           .build()

       return retrofit
   }




}