package com.example.viewbinding.livedata.room.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.viewbinding.R
import com.example.viewbinding.databinding.FragmentAddItemBinding
import com.example.viewbinding.livedata.room.RoomLiveDataActivity
import com.example.viewbinding.livedata.room.db.EntityNoteModel


class FragmentAddItem : Fragment() {


    lateinit var binding: FragmentAddItemBinding

    lateinit var activity: RoomLiveDataActivity

    lateinit var note: EntityNoteModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddItemBinding.inflate(layoutInflater, container, false)

        activity = getActivity() as RoomLiveDataActivity

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnSave.setOnClickListener {

                val id = 0
                val title = etTitle.text.toString()
                val des = etDes.text.toString()

                note = EntityNoteModel(id, title, des)


                activity.db.dao().insert(note)
                findNavController().popBackStack()

            }
        }
    }
}