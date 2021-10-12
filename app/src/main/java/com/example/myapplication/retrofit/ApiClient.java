package com.example.myapplication.retrofit;

import com.example.myapplication.model.GameModel;
import com.example.myapplication.model.Games;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface  ApiClient {

    /*@GET("api/v1/civilizations")
    Call<List<Games>> createUser();*/
    @GET("video-api/v3/")
    Call<List<GameModel>> createUser();
}
