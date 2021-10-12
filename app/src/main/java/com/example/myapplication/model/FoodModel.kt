package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FoodModel {

    @SerializedName("calories")
    @Expose
    private var calories: String? = null

    @SerializedName("carbos")
    @Expose
    private var carbos: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("difficulty")
    @Expose
    private var  difficulty:Int?=null;
    @SerializedName("fats")
    @Expose
    private var  fats: String? = null
    @SerializedName("headline")
    @Expose
    private var  headline: String? = null
    @SerializedName("id")
    @Expose
    private var  id: String? = null
    @SerializedName("image")
    @Expose
    private var  image: String? = null
    @SerializedName("name")
    @Expose
    private var  name: String? = null
    @SerializedName("proteins")
    @Expose
    private var  proteins: String? = null
    @SerializedName("thumb")
    @Expose
    private var  thumb : String? = null
    @SerializedName("time")
    @Expose
    private var time: String? = null


    fun getErrorId(): Int? {
        return difficulty
    }

    /**
     * @param errorId errorId or `null` for none
     */
    fun setErrorId(errorId: Int?):FoodModel? {
        this.difficulty = errorId
        return this
    }

}

