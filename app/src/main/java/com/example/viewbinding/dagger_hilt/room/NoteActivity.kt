package com.example.viewbinding.dagger_hilt.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.R
import com.example.viewbinding.dagger_hilt.room.adapter.AdapterNote
import com.example.viewbinding.dagger_hilt.room.db.NoteModel
import com.example.viewbinding.databinding.ActivityNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NoteActivity : AppCompatActivity() {


    lateinit var binding :ActivityNoteBinding


    @Inject
    lateinit var repository: Repository


    @Inject
    lateinit var adapterNote: AdapterNote


    @Inject
    lateinit var noteModel: NoteModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            for (i in 0..repository.getAllNote().size-1)
            {
                Log.e("TAG","${repository.getAllNote().get(i).id} :  ${repository.getAllNote().get(i).title}")
            }


            btnAdd.setOnClickListener {

//                noteModel.id=0
//                noteModel.title=et.text.toString()
                repository.insert(NoteModel(0,et.text.toString()))
                et.setText("")
                adapterNote.differ.submitList(repository.getAllNote())

            }


            adapterNote.differ.submitList(repository.getAllNote())

            rcyclrId.apply {
                layoutManager=LinearLayoutManager(this@NoteActivity)
                adapter=adapterNote
            }

          adapterNote.setOnItemClickListener {

              Toast.makeText(this@NoteActivity,"${it.id} : ${it.title}",Toast.LENGTH_SHORT).show()

          }

        }

    }
}