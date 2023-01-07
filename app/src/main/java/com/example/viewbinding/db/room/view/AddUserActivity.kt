package com.example.viewbinding.db.room.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import androidx.room.Room
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityAddUserBinding
import com.example.viewbinding.db.room.db.Const
import com.example.viewbinding.db.room.db.EntityUser
import com.example.viewbinding.db.room.db.UserDataBase
import com.google.android.material.snackbar.Snackbar

class AddUserActivity : AppCompatActivity() {


    private val userDb: UserDataBase by lazy {
        Room.databaseBuilder(this,UserDataBase::class.java,Const.DATA_BASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    lateinit var binding :ActivityAddUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnAdd.setOnClickListener {

                val name =etnName.text.toString()
                val age=etAge.text.toString()


                if (name.isNotEmpty() && age.isNotEmpty())
                {
                    userDb.dao().insert(EntityUser(0,name,age.toInt()))
                    finish()

                }else
                {
                    Snackbar.make(it,"is Empty",Snackbar.LENGTH_SHORT).show()
                }




            }

        }


    }
}