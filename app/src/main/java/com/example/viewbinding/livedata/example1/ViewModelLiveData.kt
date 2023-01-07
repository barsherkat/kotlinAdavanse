package com.example.viewbinding.livedata.example1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLiveData :ViewModel(){

    val strData :MutableLiveData<String> by lazy {MutableLiveData<String>() }


}