package com.example.viewbinding.db.room.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ItemLayoutBinding
import com.example.viewbinding.db.room.db.EntityUser

class AdapterDbRcyclr :RecyclerView.Adapter<AdapterDbRcyclr.ViewHolder>() {

    lateinit var binding: ItemLayoutBinding

    lateinit var context :Context



    inner class ViewHolder :RecyclerView.ViewHolder(binding.root)
    {

        fun setData(user: EntityUser)
        {
            binding.apply {

                tvid.text=user.id.toString()
                tvname.text=user.userName
                tvage.text=user.age.toString()


                root.setOnClickListener {

                    val intent=Intent(context,UpdateUserActivity::class.java)
                    intent.putExtra("id",user.id)

                    context.startActivity(intent)

                }
            }
        }
    }


    val differCallBack=object : DiffUtil.ItemCallback<EntityUser>()
    {
        override fun areItemsTheSame(oldItem: EntityUser, newItem: EntityUser): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: EntityUser, newItem: EntityUser): Boolean {
            return oldItem==newItem
        }
    }


    val differ =AsyncListDiffer(this,differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context=parent.context
        binding= ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(differ.currentList[position])

    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

}