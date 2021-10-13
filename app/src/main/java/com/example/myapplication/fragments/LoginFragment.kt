package com.example.myapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.model.User
import com.example.myapplication.model.UserLoginInfo
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            UserLoginInfo.user = User(username)
            val action = LoginFragmentDirections.actionLoginFragment2ToProfileFragment()
            findNavController().navigate(action)
        }
    }
}