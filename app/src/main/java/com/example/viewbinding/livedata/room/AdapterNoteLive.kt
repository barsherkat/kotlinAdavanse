package com.example.viewbinding.livedata.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ItemNote2Binding
import com.example.viewbinding.livedata.room.db.EntityNoteModel

class AdapterNoteLive : RecyclerView.Adapter<AdapterNoteLive.ViewHolder>() {


    lateinit var binding :ItemNote2Binding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding= ItemNote2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
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
        fun setData(entityNoteModel: EntityNoteModel)
        {
            binding.tvItem.text=entityNoteModel.title
            binding.tvItemDes.text=entityNoteModel.des
        }
    }


   private val diffCallBack=object :DiffUtil.ItemCallback<EntityNoteModel>()
    {
        override fun areItemsTheSame(oldItem: EntityNoteModel, newItem: EntityNoteModel): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EntityNoteModel,
            newItem: EntityNoteModel
        ): Boolean {
           return oldItem==newItem
        }
    }


    val differ = AsyncListDiffer(this,diffCallBack)




}