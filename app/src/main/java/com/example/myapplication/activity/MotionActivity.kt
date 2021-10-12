package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMotionBinding

class MotionActivity : AppCompatActivity() {
    //Data binding
    private lateinit var binding:ActivityMotionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_motion)
        binding.textRegister.setOnClickListener {
            // End the Motion
            binding.motionLayout.transitionToEnd()
        }

        binding.textLogin.setOnClickListener {
            //Start the motion Action
            binding.motionLayout.transitionToStart()
        }
    }
}