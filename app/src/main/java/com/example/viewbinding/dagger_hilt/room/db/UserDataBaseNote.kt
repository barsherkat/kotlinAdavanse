package com.example.viewbinding.dagger_hilt.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.viewbinding.dagger_hilt.room.db.DaoNote
import com.example.viewbinding.dagger_hilt.room.db.NoteModel

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
abstract class UserDataBaseNote :RoomDatabase(){

    abstract fun dao() : DaoNote

}

