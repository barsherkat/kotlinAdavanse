package com.example.viewbinding.db.room.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityMain2Binding
import com.example.viewbinding.db.room.db.Const
import com.example.viewbinding.db.room.db.EntityUser
import com.example.viewbinding.db.room.db.UserDataBase

class MainActivity : AppCompatActivity() {


    private val userDb: UserDataBase by lazy {
        Room.databaseBuilder(this, UserDataBase::class.java, Const.DATA_BASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    lateinit var binding: ActivityMain2Binding


    val adapterDb by lazy { AdapterDbRcyclr() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            btnAdd.setOnClickListener {
                startActivity(Intent(this@MainActivity,AddUserActivity::class.java))
            }


            etSrc.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {



                    checkRecyclr(userDb.dao().getUserByName(s.toString()))

                }
            })


        }
    }


    fun checkRecyclr( list: MutableList<EntityUser>) {
        binding.apply {
            if (list.isEmpty()) {
                tvEmptyTitle.visibility = View.VISIBLE
                rcyclrId.visibility = View.GONE
            } else {
                tvEmptyTitle.visibility = View.GONE
                rcyclrId.apply {
                    visibility = View.VISIBLE

                    adapterDb.differ.submitList(list)

                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = adapterDb
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()

        checkRecyclr(userDb.dao().getAllUser())
    }


}