package com.example.viewbinding.db.room.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoUser {


    @Insert(onConflict = REPLACE)
    fun insert(entityUser: EntityUser)


    @Update
    fun update(entityUser: EntityUser)


    @Delete
    fun delete(entityUser: EntityUser)

//    @Query("SELECT * FROM ${Const.TABLE_NAME} ORDER BY id ASC")
    @Query("SELECT * FROM ${Const.TABLE_NAME} ORDER BY id DESC")
    fun getAllUser() :MutableList<EntityUser>


    @Query("SELECT * FROM ${Const.TABLE_NAME} WHERE id LIKE :idUser")
    fun geUserById(idUser :Int) : EntityUser


    @Query("DELETE FROM ${Const.TABLE_NAME}")
    fun deleteAllEntity()


    @Query("SELECT * FROM ${Const.TABLE_NAME} WHERE name LIKE '%'||:name_serc||'%'")
    fun getUserByName(name_serc :String) :MutableList<EntityUser>

}