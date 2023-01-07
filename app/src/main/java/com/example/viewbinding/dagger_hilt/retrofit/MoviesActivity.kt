package com.example.viewbinding.dagger_hilt.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.dagger_hilt.retrofit.adapter.AdapterMovies
import com.example.viewbinding.dagger_hilt.retrofit.model.MoviesAllModel
import com.example.viewbinding.dagger_hilt.retrofit.repository.RepositoryApi
import com.example.viewbinding.databinding.ActivityMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {


    lateinit var binding: ActivityMoviesBinding

    @Inject
    lateinit var adapterMovies: AdapterMovies


    @Inject
    lateinit var repository: RepositoryApi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            repository.getAllMovies().enqueue(object : Callback<MoviesAllModel> {
                override fun onResponse(
                    call: Call<MoviesAllModel>,
                    response: Response<MoviesAllModel>
                ) {
                    prgrs.visibility = View.GONE

                    if (response.isSuccessful) {
                        response.body()?.let { itBody ->
                            itBody.data?.let { itData ->

                                if (itData.isNotEmpty()) {
                                    adapterMovies.differ.submitList(itData)
                                    rcyclrId.apply {
                                        layoutManager = LinearLayoutManager(this@MoviesActivity)
                                        adapter = adapterMovies
                                    }
                                }
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MoviesAllModel>, t: Throwable) {
                    prgrs.visibility = View.GONE
                }

            })

        }


    }
}