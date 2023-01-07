package com.example.viewbinding.dagger_hilt.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.viewbinding.dagger_hilt.retrofit.model.MoviesAllModel
import com.example.viewbinding.databinding.ItemMoviesBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdapterMovies @Inject constructor():RecyclerView.Adapter<AdapterMovies.ViewHolder>() {


    lateinit var binding :ItemMoviesBinding

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


    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder :RecyclerView.ViewHolder(binding.root)
    {
        fun setData(item:MoviesAllModel.Data)
        {
            binding.apply {

                tvTitle.text=item.title
                iv.load(item.poster){
                    crossfade(true)
                    crossfade(1000)
                }

            }
        }

    }

   private val diffCallBack=object :DiffUtil.ItemCallback<MoviesAllModel.Data>()
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



   val differ=AsyncListDiffer(this,diffCallBack)




}