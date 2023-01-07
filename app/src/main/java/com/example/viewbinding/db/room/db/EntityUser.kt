package com.example.viewbinding.db.room.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewbinding.db.room.db.Const


@Entity(tableName = Const.TABLE_NAME)
data class EntityUser(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = Const.FIELD_NAME)
    val userName :String,
    @ColumnInfo(name = Const.FIELD_AGE)
    val age :Int
    )
