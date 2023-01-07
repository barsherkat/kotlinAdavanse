package com.example.viewbinding.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityMainBottomNavigationBinding
import com.example.viewbinding.databinding.ActivityMainNavigationExampleBinding

class MainActivityBottomNavigation : AppCompatActivity() {

    lateinit var binding :ActivityMainBottomNavigationBinding

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            navController=findNavController(R.id.fragment)

            appBarConfiguration= AppBarConfiguration(
                setOf(R.id.addPostFragment,R.id.favoriteFragment,R.id.homeFragment2
                    ,R.id.profileFragment,R.id.searchFragment))


            setupActionBarWithNavController(navController,appBarConfiguration)

            btnNav.setupWithNavController(navController)

        }

    }

    override fun onNavigateUp(): Boolean {
        return  navController.navigateUp() || super.onNavigateUp()
    }
}