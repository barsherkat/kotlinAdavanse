package com.example.viewbinding.dagger_hilt.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewbinding.dagger_hilt.di.TABLE_NAME


@Dao
interface DaoNote {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note : NoteModel)


    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllNote() :MutableList<NoteModel>


}