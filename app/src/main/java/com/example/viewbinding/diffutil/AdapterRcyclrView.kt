package com.example.viewbinding.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ItemLayoutBinding

class AdapterRcyclrView :RecyclerView.Adapter<AdapterRcyclrView.ViewHolder>()
{

    lateinit var binding: ItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding= ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)


        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(differ.currentList[position])

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class ViewHolder :RecyclerView.ViewHolder(binding.root)
    {
        fun setData(modelData: ModelData)
        {
            binding.tvname.text=modelData.name
            binding.tvage.text=modelData.age.toString()
            binding.tvid.text=modelData.id.toString()
        }
    }


    private val differCallBack =object :DiffUtil.ItemCallback<ModelData>()
    {
        override fun areItemsTheSame(oldItem: ModelData, newItem: ModelData): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ModelData, newItem: ModelData): Boolean {
            return oldItem==newItem
        }

    }


     val differ =AsyncListDiffer(this,differCallBack)



}