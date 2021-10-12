package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.model.FoodModel
import com.example.myapplication.retrofit.ApiEndUrl
import com.example.myapplication.retrofit.ApiServiceClient
import retrofit2.Response

class FoodViewModel: ViewModel() {
    private var remoteProviderListObservable: MutableLiveData<FoodModel>? = null
    private lateinit var retService: ApiEndUrl


    fun registerProvider(): LiveData<Response<FoodModel>> =  liveData  {
        retService = ApiServiceClient.getRetrofits()
                .create(ApiEndUrl::class.java)
      remoteProviderListObservable = MutableLiveData<FoodModel>()

        val response = retService.getFoods()
        emit(response)
    }
}