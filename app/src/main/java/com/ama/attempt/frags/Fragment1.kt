package com.ama.attempt.frags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ama.attempt.R
import com.ama.attempt.base.Item
import com.ama.attempt.base.MainDb
import com.ama.attempt.databinding.Fragment1Binding


class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)

        val db = MainDb.getDb(Fragment1())


        binding.buttonF3.setOnClickListener {
            val item = Item(
                null,
                binding.nameOf.toString(),
                binding.ageOf.text.toString(),
            )
            Thread{
                db.getDao().insertItem(item)
            }.start()


    }


}
    }