package com.example.viewbinding.dagger_hilt.retrofit.repository

import com.example.viewbinding.dagger_hilt.retrofit.api.ApiService
import javax.inject.Inject

class RepositoryApi @Inject constructor(private val apiService: ApiService) {

    fun getAllMovies()=apiService.getAllMovies(1)
}