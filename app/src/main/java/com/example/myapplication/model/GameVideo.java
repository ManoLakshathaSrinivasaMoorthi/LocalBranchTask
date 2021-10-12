package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameVideo {


    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("embed")
    @Expose
    private String embed;

    /**
     * No args constructor for use in serialization
     *
     */
    public GameVideo() {
    }

    /**
     *
     * @param embed
     * @param title
     */
    public GameVideo(String title, String embed) {
        super();
        this.title = title;
        this.embed = embed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

}
