package com.example.viewbinding.dagger_hilt.dagger_test.di

import com.example.viewbinding.dagger_hilt.di.AGE
import com.example.viewbinding.dagger_hilt.di.FATHER_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)////////////////////////فقط یکبار تعریف میشود
object MainModule {

    @Provides
    @Singleton
    fun provideUserName()="ali"


    @Provides
    @LastName
    fun provideLastName() :String
    {
        return "nouri"
    }


    @Provides
    @Named(FATHER_NAME)
    fun provideFatherName()="gholam"



    @Provides
    @Named(AGE)
    fun provideAge():String
    {
        return "28"
    }




}