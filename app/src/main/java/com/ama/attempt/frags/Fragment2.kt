package com.ama.attempt.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.ama.attempt.R
import com.ama.attempt.base.MainDb
import com.ama.attempt.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)

        val db = MainDb.getDb(Fragment1())

        db.getDao().getAllItem().asLiveData().observe(viewLifecycleOwner){ list->
            binding.tvList.text = ""
            list.forEach {
                val text = "Id: ${it.id} Name: ${it.name} Price: ${it.age}\n"
                binding.tvList.append(text)
            }
        }


    }
}


