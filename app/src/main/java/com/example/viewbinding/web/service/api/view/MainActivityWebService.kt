package com.example.viewbinding.web.service.api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.R
import com.example.viewbinding.databinding.ActivityMainWebServiceBinding
import com.example.viewbinding.web.service.api.api.ApiClient
import com.example.viewbinding.web.service.api.api.ApiService
import com.example.viewbinding.web.service.api.model.MoviesAllModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityWebService : AppCompatActivity() {

    lateinit var binding: ActivityMainWebServiceBinding

    val adapterMovies by lazy { AdapterMovies() }

   private val api :ApiService by lazy {

       ApiClient().getClient().create(ApiService::class.java)

   }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainWebServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            prgrres.visibility= View.VISIBLE

            val callMoviesApi=api.getAllListMovies(1)

            callMoviesApi.enqueue(object :Callback<MoviesAllModel>
            {
                override fun onResponse(
                    call: Call<MoviesAllModel>,
                    response: Response<MoviesAllModel>
                ) {

                    prgrres.visibility= View.GONE

                    if (response.isSuccessful)
                    {
                        response.body()?.let { itBody->
                            itBody.data?.let { itData->
                                if (itData.isNotEmpty())
                                {
                                    adapterMovies.differ.submitList(itData)

                                    rcyclrId.apply {

                                        layoutManager=LinearLayoutManager(this@MainActivityWebService)
                                        adapter=adapterMovies

                                    }
                                }

                            }


                        }
                    }




                }

                override fun onFailure(call: Call<MoviesAllModel>, t: Throwable) {

                    prgrres.visibility= View.GONE


                }

            })


        }

    }
}