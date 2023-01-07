package com.example.viewbinding.viewmodel.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.viewbinding.databinding.ActivityViewModelExamBinding

class ViewModelExamActivity : AppCompatActivity() {

    lateinit var binding :ActivityViewModelExamBinding

    var count=0

    /////////////// init ViewModel /////////
    val viewModel : ViewModelMain by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewModelExamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            tv.text= viewModel.count.toString()

            btn.setOnClickListener {

//                count++
//                tv.text=count.toString()

                viewModel.addNum()
                tv.text= viewModel.count.toString()



            }


        }



    }
}