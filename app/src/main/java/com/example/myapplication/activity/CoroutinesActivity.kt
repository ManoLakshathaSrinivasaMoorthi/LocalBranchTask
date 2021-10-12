package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.FoodViewModel
import com.google.gson.Gson

class CoroutinesActivity : AppCompatActivity() {
    private var viewModel: FoodViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        viewModel=ViewModelProvider(this).get(FoodViewModel::class.java)

        viewModel?.registerProvider()?.observe(this,{
            val response=it.body()
            Log.d("Output:",Gson().toJson(response))
          val textview=  response?.getErrorId()
        })
    }
}