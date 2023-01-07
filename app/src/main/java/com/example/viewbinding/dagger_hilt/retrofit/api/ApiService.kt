package com.example.viewbinding.dagger_hilt.retrofit.api

import com.example.viewbinding.dagger_hilt.retrofit.model.MoviesAllModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("movies")
    fun getAllMovies(@Query("page") page:Int):Call<MoviesAllModel>

}