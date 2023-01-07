package com.example.viewbinding.db.room.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityUser::class], version = 100)
abstract class UserDataBase :RoomDatabase(){

    abstract fun dao():DaoUser

}