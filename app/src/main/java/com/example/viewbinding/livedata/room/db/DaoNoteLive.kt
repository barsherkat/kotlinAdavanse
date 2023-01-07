package com.example.viewbinding.livedata.room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewbinding.livedata.room.TABLE_NAME

@Dao
interface DaoNoteLive {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entityNoteModel: EntityNoteModel)


    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllData():LiveData<MutableList<EntityNoteModel>>


}