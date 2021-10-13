package com.example.myapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_show_profile.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToLoginFragment2()
          //  findNavController().navigate(action)
        }
    }
}