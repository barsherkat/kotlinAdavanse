package com.example.viewbinding.dagger_hilt.dagger_test.di

import android.content.Context
import com.example.viewbinding.R
import com.example.viewbinding.dagger_hilt.di.STR_VALUE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named(STR_VALUE)
    /////////////Context بصورت خودکار وارد میشود نیاز ب وارد کردن دستی ندارد///@ApplicationContext///////////
    fun getString(@ApplicationContext context: Context):String
    {
        return context.getString(R.string.app_name)
    }



}