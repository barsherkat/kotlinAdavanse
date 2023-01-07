package com.example.viewbinding.dagger_hilt.room.di

import android.content.Context
import androidx.room.Room
import com.example.viewbinding.dagger_hilt.di.DATA_BASE_NAME
import com.example.viewbinding.dagger_hilt.room.db.NoteModel
import com.example.viewbinding.dagger_hilt.room.db.UserDataBaseNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DbModule {


    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            UserDataBaseNote::class.java,
            DATA_BASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun provideDao(db: UserDataBaseNote) = db.dao()

    @Provides
    fun provideEntity() = NoteModel()


}