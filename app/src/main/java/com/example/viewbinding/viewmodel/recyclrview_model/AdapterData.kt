package com.example.viewbinding.viewmodel.recyclrview_model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ItemNoteBinding

class AdapterData : RecyclerView.Adapter<AdapterData.ViewHolder>() {

    lateinit var binding :ItemNoteBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding=ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)
    {
        fun setData(dataModel: DataModel){

            binding.tvItem.text="${dataModel.id} -> ${dataModel.item} "

        }
    }


   private val diffCallBack=object : DiffUtil.ItemCallback<DataModel>() {
        override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem==newItem
        }
    }


    val differ =AsyncListDiffer(this,diffCallBack)



}