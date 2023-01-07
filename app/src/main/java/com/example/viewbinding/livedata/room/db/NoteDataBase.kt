package com.example.viewbinding.livedata.room.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityNoteModel::class], version = 1, exportSchema = false)
abstract class NoteDataBase :RoomDatabase() {

    abstract fun dao():DaoNoteLive

}