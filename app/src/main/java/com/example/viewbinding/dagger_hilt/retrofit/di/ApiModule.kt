package com.example.viewbinding.dagger_hilt.retrofit.di

import com.example.viewbinding.dagger_hilt.di.*
import com.example.viewbinding.dagger_hilt.retrofit.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter.Factory
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Provides
    @Singleton
    @Named(NAMDED_URL)
    fun provideBaseUrl() = BASE_URL


    @Provides
    @Singleton
    fun provideTime() = NETWORK_TIMEOUT


    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().setLenient().create()


    @Provides
    @Singleton
    @Named(NAMED_HEADERS)
    fun provideHeaderInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.HEADERS
    }


    @Provides
    @Singleton
    @Named(NAMED_BODY)
    fun provideBodyInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    @Provides
    @Singleton
    fun provideClient(
        time: Long,
        @Named(NAMED_HEADERS) headers: HttpLoggingInterceptor,
        @Named(NAMED_BODY) body: HttpLoggingInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(headers)
        .addInterceptor(body)
        .writeTimeout(time, TimeUnit.SECONDS)
        .readTimeout(time, TimeUnit.SECONDS)
        .connectTimeout(time, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        @Named(NAMDED_URL) url: String,
        gson: Gson,
        client: OkHttpClient
    ) =
        Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)


}