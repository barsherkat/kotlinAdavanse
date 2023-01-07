package com.example.viewbinding.dagger_hilt.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewbinding.dagger_hilt.di.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id :Int=0 ,
    var title :String=""
)
