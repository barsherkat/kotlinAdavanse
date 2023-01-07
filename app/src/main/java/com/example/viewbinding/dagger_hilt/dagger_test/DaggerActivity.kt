package com.example.viewbinding.dagger_hilt.dagger_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.dagger_hilt.dagger_test.di.LastName
import com.example.viewbinding.dagger_hilt.di.AGE
import com.example.viewbinding.dagger_hilt.di.FATHER_NAME
import com.example.viewbinding.dagger_hilt.di.STR_VALUE
import com.example.viewbinding.databinding.ActivityDaggerBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class DaggerActivity : AppCompatActivity() {
    lateinit var binding: ActivityDaggerBinding


    @Inject
    lateinit var userName: String


    @Inject
    @LastName
    lateinit var lastName: String


    @Inject
    @Named(FATHER_NAME)
    lateinit var fatherName: String


    @Inject
    @Named(AGE)
    lateinit var age :String


    @Inject
    @Named(STR_VALUE)
    lateinit var str:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaggerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

//           tv.text=userName
//           tv.text = lastName
//            tv.text = fatherName
//            tv.text = age
            tv.text=str

        }

    }
}