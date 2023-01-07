package com.example.viewbinding.dagger_hilt.room.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.dagger_hilt.room.db.NoteModel
import com.example.viewbinding.databinding.ItemNoteBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdapterNote @Inject constructor() : RecyclerView.Adapter<AdapterNote.ViewHolder>() {

    private lateinit var binding: ItemNoteBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(noteModel: NoteModel) {
            binding.apply {

                tvItem.text = "${noteModel.id} : ${noteModel.title}"

                root.setOnClickListener {

                    onItemClickListener?.let {

                        it(noteModel)

                    }

                    }
                }
            }
        }

    val diffCallBack = object : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)


    private var onItemClickListener: ((NoteModel) -> Unit)? =null

    fun setOnItemClickListener(listener :(NoteModel)->Unit)
    {
        onItemClickListener=listener
    }

}