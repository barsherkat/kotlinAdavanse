package com.example.viewbinding.db.room.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityUpdateUserBinding
import com.example.viewbinding.db.room.db.Const
import com.example.viewbinding.db.room.db.EntityUser
import com.example.viewbinding.db.room.db.UserDataBase
import com.google.android.material.snackbar.Snackbar

class UpdateUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateUserBinding

    var user_id =-1

    private val userDb: UserDataBase by lazy {
        Room.databaseBuilder(this, UserDataBase::class.java, Const.DATA_BASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        intent.extras?.let {

            user_id=it.getInt("id")

        }


        binding.apply {


            userDb.dao().geUserById(user_id).apply {

                etName.setText(this.userName)
                etAge.setText(this.age.toString())
            }



            btnOk.setOnClickListener {

                val name =etName.text.toString()
                val age=etAge.text.toString()

                if (name.isNotEmpty() && age.isNotEmpty())
                {
                    userDb.dao().update(EntityUser(user_id,name,age.toInt()))
                    finish()
                }else
                {
                   Snackbar.make(root,"is empty",Snackbar.LENGTH_SHORT).show()
                }
            }


            btnDlt.setOnClickListener {

                val name =etName.text.toString()
                val age=etAge.text.toString()

                if (name.isNotEmpty() && age.isNotEmpty())
                {
                    userDb.dao().delete(EntityUser(user_id,name,age.toInt()))
                    finish()
                }else
                {
                    Snackbar.make(root,"is empty",Snackbar.LENGTH_SHORT).show()
                }
            }




        }



    }
}