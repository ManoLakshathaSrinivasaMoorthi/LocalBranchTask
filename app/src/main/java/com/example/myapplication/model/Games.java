package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Games {

    @SerializedName("civilizations")
    @Expose
    private List<Civilization> civilizations = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Games() {
    }

    /**
     *
     * @param civilizations
     */
    public Games(List<Civilization> civilizations) {
        super();
        this.civilizations = civilizations;
    }

    public List<Civilization> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<Civilization> civilizations) {
        this.civilizations = civilizations;
    }

}

