package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameResponse {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("competition")
    @Expose
    private String competition;
    @SerializedName("matchviewUrl")
    @Expose
    private String matchviewUrl;
    @SerializedName("competitionUrl")
    @Expose
    private String competitionUrl;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("videos")
    @Expose
    private List<GameVideo> videos = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public GameResponse() {
    }

    /**
     *
     * @param date
     * @param thumbnail
     * @param matchviewUrl
     * @param competition
     * @param videos
     * @param title
     * @param competitionUrl
     */
    public GameResponse(String title, String competition, String matchviewUrl, String competitionUrl, String thumbnail, String date, List<GameVideo> videos) {
        super();
        this.title = title;
        this.competition = competition;
        this.matchviewUrl = matchviewUrl;
        this.competitionUrl = competitionUrl;
        this.thumbnail = thumbnail;
        this.date = date;
        this.videos = videos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getMatchviewUrl() {
        return matchviewUrl;
    }

    public void setMatchviewUrl(String matchviewUrl) {
        this.matchviewUrl = matchviewUrl;
    }

    public String getCompetitionUrl() {
        return competitionUrl;
    }

    public void setCompetitionUrl(String competitionUrl) {
        this.competitionUrl = competitionUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<GameVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<GameVideo> videos) {
        this.videos = videos;
    }

}
