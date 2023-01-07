package com.example.viewbinding.livedata.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewbinding.livedata.room.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class EntityNoteModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title :String="",
    var des :String=""
)
