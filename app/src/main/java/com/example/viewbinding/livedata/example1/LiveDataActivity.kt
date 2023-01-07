package com.example.viewbinding.livedata.example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.viewbinding.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {

    lateinit var binding :ActivityLiveDataBinding

    val viewModel : ViewModelLiveData by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            btn.setOnClickListener {

                viewModel.strData.value="ali"
            }

            val observer =Observer<String>{
                tv.text=it
            }

            viewModel.strData.observe(this@LiveDataActivity,observer)
        }


    }
}