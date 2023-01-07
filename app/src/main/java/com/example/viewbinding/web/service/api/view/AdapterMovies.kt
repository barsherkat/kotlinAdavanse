package com.example.viewbinding.web.service.api.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.viewbinding.databinding.ItemMoviesBinding
import com.example.viewbinding.web.service.api.model.MoviesAllModel

class AdapterMovies :RecyclerView.Adapter<AdapterMovies.ViewHolder>() {


    lateinit var binding: ItemMoviesBinding


    inner class ViewHolder :RecyclerView.ViewHolder(binding.root)
    {
        fun setData(data :MoviesAllModel.Data)
        {
            binding.apply {

                tvTitle.text=data.title
                iv.load(data.poster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding= ItemMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.setData(differ.currentList[position])


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    val diffCallBack=object :DiffUtil.ItemCallback<MoviesAllModel.Data>()
    {
        override fun areItemsTheSame(
            oldItem: MoviesAllModel.Data,
            newItem: MoviesAllModel.Data
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MoviesAllModel.Data,
            newItem: MoviesAllModel.Data
        ): Boolean {
            return oldItem==newItem
        }
    }


    val differ =AsyncListDiffer(this,diffCallBack)


}