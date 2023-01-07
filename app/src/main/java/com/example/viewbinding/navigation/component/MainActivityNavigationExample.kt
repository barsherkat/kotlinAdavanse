package com.example.viewbinding.navigation.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityMainNavigationExampleBinding

class MainActivityNavigationExample : AppCompatActivity() {

    lateinit var binding :ActivityMainNavigationExampleBinding

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainNavigationExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            navController=findNavController(R.id.fragmentContainerView)

            appBarConfiguration= AppBarConfiguration(setOf(R.id.homeFragment,R.id.detaileFragment,R.id.blankFragment))

            setupActionBarWithNavController(navController,appBarConfiguration)

        }
    }


    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}