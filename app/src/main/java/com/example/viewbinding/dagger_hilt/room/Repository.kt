package com.example.viewbinding.dagger_hilt.room

import com.example.viewbinding.dagger_hilt.room.db.DaoNote
import com.example.viewbinding.dagger_hilt.room.db.NoteModel
import javax.inject.Inject

class Repository @Inject constructor(private val dao :DaoNote) {

    fun insert(noteModel: NoteModel)=dao.insert(noteModel)
    fun getAllNote()=dao.getAllNote()

}