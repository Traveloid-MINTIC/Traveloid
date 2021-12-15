package com.traveloiddevs.cundinamarcago.data

class TouristplacesRepository {
    suspend fun getTouristPlaces() = ApiFactory.retrofit.getTouristPlaces()
}