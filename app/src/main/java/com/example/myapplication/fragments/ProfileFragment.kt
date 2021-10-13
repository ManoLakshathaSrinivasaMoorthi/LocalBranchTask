package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.model.UserLoginInfo
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = UserLoginInfo.user!!.username
        Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()

        val text = getString(R.string.welcome, username)
        tv_welcome.text = text
    }
}