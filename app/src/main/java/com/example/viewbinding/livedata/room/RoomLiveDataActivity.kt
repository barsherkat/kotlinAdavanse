package com.example.viewbinding.livedata.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityRoomLiveDataBinding
import com.example.viewbinding.livedata.room.db.NoteDataBase

class RoomLiveDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomLiveDataBinding

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    val db by lazy {
        Room.databaseBuilder(this, NoteDataBase::class.java, DATA_BASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            navController = findNavController(R.id.frgmnt)
            appBarConfiguration = AppBarConfiguration(navController.graph)
            setupActionBarWithNavController(navController,appBarConfiguration)
        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}