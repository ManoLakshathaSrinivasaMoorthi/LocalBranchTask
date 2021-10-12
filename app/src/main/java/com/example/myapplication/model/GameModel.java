package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameModel {


    @SerializedName("response")
    @Expose
    private List<GameResponse> response = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public GameModel() {
    }

    /**
     *
     * @param response
     */
    public GameModel(List<GameResponse> response) {
        super();
        this.response = response;
    }

    public List<GameResponse> getResponse() {
        return response;
    }

    public void setResponse(List<GameResponse> response) {
        this.response = response;
    }
}
