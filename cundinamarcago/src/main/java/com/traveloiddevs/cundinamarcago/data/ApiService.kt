package com.traveloiddevs.cundinamarcago.data

import com.traveloiddevs.cundinamarcago.model.TouristPlace
import retrofit2.http.GET

interface ApiService {
    @GET("Katherine026/Explicacion/touristplaces")
    suspend fun getTouristPlaces(): TouristPlace
}