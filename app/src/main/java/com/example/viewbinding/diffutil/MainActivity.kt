package com.example.viewbinding.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val adapterRcyclrView by lazy { AdapterRcyclrView() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterRcyclrView.differ.submitList(getData())

        binding.rcyclrId.apply {

            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=adapterRcyclrView

        }


    }


    fun getData() :MutableList<ModelData>
    {
        val list :MutableList<ModelData> = mutableListOf()

        list.add(ModelData(1,"ali",20))
        list.add(ModelData(2,"reza",22))
        list.add(ModelData(3,"mohammad",21))
        list.add(ModelData(4,"kaveh",25))
        list.add(ModelData(5,"mona",32))
        list.add(ModelData(6,"karim",29))
        list.add(ModelData(7,"akbar",26))
        list.add(ModelData(8,"alireza",21))
        list.add(ModelData(9,"hasan",24))
        list.add(ModelData(10,"mina",19))


        return list
    }


}