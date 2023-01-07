package com.example.viewbinding.viewmodel.recyclrview_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityMain3Binding

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMain3Binding

    val adapterData by lazy{AdapterData()}


    val viewModel :ViewModelData by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {


//            adapterData.differ.submitList(Util.getAllData())

            adapterData.differ.submitList(viewModel.getData())

            rcyclrId.apply {
                layoutManager=LinearLayoutManager(this@MainActivity)
                adapter=adapterData
            }


        }


    }
}