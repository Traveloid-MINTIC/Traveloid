package com.traveloiddevs.cundinamarcago.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TouristPlaceItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("descriptionCard")
    val descriptionCard: String,
    @SerializedName("elevation")
    val elevation: String,
    @SerializedName("history")
    val history: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("ratingStart")
    val ratingStart: String,
    @SerializedName("restaurants")
    val restaurants: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("weather")
    val weather: String
) : Serializable