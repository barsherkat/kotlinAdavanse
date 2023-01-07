package com.example.viewbinding.livedata.check_internet

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityCheckInternetBinding

class CheckInternetActivity : AppCompatActivity() {

    lateinit var binding :ActivityCheckInternetBinding

    private val checkConnection by lazy { CheckConnection(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCheckInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            checkConnection.observe(this@CheckInternetActivity ){

                if (it)
                {
                   iv.setImageResource(R.drawable.ic_baseline_wifi_24)
                    iv.setColorFilter(
                        ContextCompat.getColor(this@CheckInternetActivity,R.color.green),
                        PorterDuff.Mode.MULTIPLY
                    )
                   tv.text="Connected"
                   tv.setTextColor(ContextCompat.getColor(this@CheckInternetActivity, R.color.green) )
                }else
                {
                    iv.setImageResource(R.drawable.ic_baseline_wifi_off_24)
                    iv.setColorFilter(
                        ContextCompat.getColor(this@CheckInternetActivity,R.color.red),
                        PorterDuff.Mode.MULTIPLY
                    )
                    tv.text="DissConnected"
                    tv.setTextColor(ContextCompat.getColor(this@CheckInternetActivity,R.color.red))
                }

            }


        }

    }
}