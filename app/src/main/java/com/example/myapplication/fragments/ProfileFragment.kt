package com.example.myapplication.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.model.UserLoginInfo

class ProfileFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = UserLoginInfo.user!!.username
        Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()

        val text = getString(R.string.welcome, username)
        tv_welcome.text = text
    }
}