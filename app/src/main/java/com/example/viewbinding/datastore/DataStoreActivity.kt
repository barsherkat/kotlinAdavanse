package com.example.viewbinding.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityDataStoreBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreActivity : AppCompatActivity() {

    lateinit var binding :ActivityDataStoreBinding

    private val dataStore :DataStore<Preferences> by preferencesDataStore("data_store_name")
    private val nameKey = stringPreferencesKey("user_name")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {


            btn.setOnClickListener {

                CoroutineScope(IO).launch {

                    setDataStore(et.text.toString())
                    et.setText("")
                }
            }

            lifecycle.coroutineScope.launchWhenCreated {

                getDataStore().collect{

                    tv.text=it
                }
            }
        }
    }

    private suspend fun setDataStore(name :String){

        dataStore.edit {

            it[nameKey]=name
        }
    }


    private fun getDataStore()=dataStore.data.map {

        it[nameKey]?:""

    }



}