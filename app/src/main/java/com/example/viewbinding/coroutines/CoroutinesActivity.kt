package com.example.viewbinding.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class CoroutinesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCoroutinesBinding


    lateinit var job :Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesBinding.inflate(layoutInflater)
        setContentView(binding.root)


/////////////////////////////////////////خودش رو با lifecycle هماهنگ میکنه------->  lifecycleScope  ////////////////////////
        lifecycleScope.launch {

            while (true){
                Log.e("Tag","working . . .")
                delay(1000)
            }
        }
        CoroutineScope(Dispatchers.Main).launch{

            delay(5000)
           Intent(this@CoroutinesActivity,SecondActivity::class.java) .also{

               startActivity(it)
               finish()
           }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////



//        CoroutineScope(Dispatchers.Main).launch {
//        val job2=CoroutineScope(Dispatchers.Main).launch {
//
//            repeat(3){
//
//                delay(1000)
//                Log.e("Tag","Working . . . .")
//            }
//        }
//            delay(4000)
//
//            job2.cancelAndJoin()
////            job2.cancel()
////            job2.join()
//            Log.e("Tag","Done")
//        }


        /////////////////////////////////////////////////
//        job=CoroutineScope(Dispatchers.Main).launch {
//
//            delay(1000)
//            Log.e("Tag","doWork")
//        }
//
//        Log.e("Tag","isActive :  "+job.isActive.toString())
//        Log.e("Tag","isCompleted :  "+job.isCompleted.toString())
//        Log.e("Tag","isCancelled :  "+job.isCancelled.toString())
//
//        job.cancel()
//
//        CoroutineScope(Dispatchers.Main).launch {
//
//            delay(5000)
//
//            Log.e("Tag","isActive :  "+job.isActive.toString())
//            Log.e("Tag","isCompleted :  "+job.isCompleted.toString())
//            Log.e("Tag","isCancelled :  "+job.isCancelled.toString())
//
//        }


//        CoroutineScope(Dispatchers.IO).launch {
//
////////////////فقط در تایم مورد نظر کار انجام میدهد///////////////////////
//            withTimeoutOrNull(5000){
//                for (i in 1000..1100)
//                {
//                    Log.e("Tag",i.toString())
//                    delay(1000)
//                }
//
//            }
//        }



//        CoroutineScope(Dispatchers.IO).launch {
////////////////// تکرار //////////
//            repeat(3) {
//
//                Log.e("Tag",showLog())
//            }
//        }



//        CoroutineScope(Dispatchers.IO).launch {
//            showLog()
//
////////////  (IO===>Main) تعویض Thread //////////////
//            withContext(Dispatchers.Main)
//            {
//                binding.et.setText("reza")
//            }
//        }


/////////////////////////ساخت یک Custom Thread با نام شخصی /////////////////////////
//        CoroutineScope(newSingleThreadContext("ali")).launch {
//            Log.e("Tag",Thread.currentThread().name)
//        }
//////////////////////////////////////////

////////////////بلاک کردن  UI  و Thread اصلی (main) //////////
//        runBlocking {
//            delay(3000)
//        }
//////////////////////////////



//        CoroutineScope(Dispatchers.Main).launch {
//////////////////کارهارو بصورت همزمان انجام میده//////////////////
//            val res1=async { showLog() }
//            val res2=async { showLog_2() }
//
//            var resAll =" "
//            val timer = measureTimeMillis {
//
//                resAll ="${res1.await()} ${res2.await()}"
//            }
//            Log.e("Tag", "$resAll  ==> $timer")
//////////////////////////////////////////////////////////////////////////////////


//////////////////کارهارو پشت سر هم انجام میده///////////////////////
//            val time = measureTimeMillis {
//                val str1 = showLog()
//                val str2 = showLog_2()
//
//                Log.e("Tag", str1)
//                Log.e("Tag", str2)
//            }
//            Log.e("Tag",time.toString())

/////////////////////////////////////////////////////////////////////////////////////
//        }


    }


    private suspend fun showLog(): String {
        delay(2000)
        return "result1"
    }


    private suspend fun showLog_2(): String {
        delay(1000)
        return "result2"
    }


}