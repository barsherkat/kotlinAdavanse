package com.example.viewbinding.web.service.api.api

import com.example.viewbinding.web.service.api.model.MoviesAllModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movies")
    fun getAllListMovies(@Query("page") page :Int ) : Call<MoviesAllModel>


}