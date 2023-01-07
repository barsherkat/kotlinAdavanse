package com.example.viewbinding.viewmodel.recyclrview_model

import androidx.lifecycle.ViewModel

class ViewModelData :ViewModel() {

    fun getData():MutableList<DataModel>
    {
       return Util.getAllData()
    }

}