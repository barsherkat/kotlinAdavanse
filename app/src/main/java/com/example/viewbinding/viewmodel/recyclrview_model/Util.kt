package com.example.viewbinding.viewmodel.recyclrview_model

object Util {

    fun getAllData():MutableList<DataModel>
    {
        val list :MutableList<DataModel> = mutableListOf()

        for (i in 1..100)
        {
            list.add(DataModel(i,"item ${i}"))
        }

       return list
    }


}