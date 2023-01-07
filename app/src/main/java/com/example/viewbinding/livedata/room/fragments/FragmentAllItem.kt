package com.example.viewbinding.livedata.room.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.viewbinding.R
import com.example.viewbinding.databinding.FragmentAllItemBinding
import com.example.viewbinding.livedata.room.AdapterNoteLive
import com.example.viewbinding.livedata.room.RoomLiveDataActivity
import com.example.viewbinding.livedata.room.db.EntityNoteModel


class FragmentAllItem : Fragment() {


    lateinit var binding :FragmentAllItemBinding

    lateinit var list:MutableList<EntityNoteModel>

    val adapterNote by lazy { AdapterNoteLive() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAllItemBinding.inflate(layoutInflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {


            btnAdd.setOnClickListener {

                findNavController().navigate(R.id.action_fragmentAllItem_to_fragmentAddItem)

            }

            (activity as RoomLiveDataActivity).db.dao().getAllData().observe(viewLifecycleOwner){

                adapterNote.differ.submitList(it)
                rcyclrId.apply {
                    layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                    adapter=adapterNote
                }

            }

        }

    }
}