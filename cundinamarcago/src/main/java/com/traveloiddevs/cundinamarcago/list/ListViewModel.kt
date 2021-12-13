package com.traveloiddevs.cundinamarcago.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.traveloiddevs.cundinamarcago.model.TouristPlace
import com.traveloiddevs.cundinamarcago.model.TouristPlaceItem
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var touristPlacesLoad : MutableLiveData<ArrayList<TouristPlaceItem>> = MutableLiveData()
    val onTouristPlacesLoaded : LiveData<ArrayList<TouristPlaceItem>> = touristPlacesLoad

    fun loadMockTouristPlacesFromJson(TouristPlacesString: InputStream?) {
        val TouristPlaceString= TouristPlacesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        touristPlacesLoad.value = gson.fromJson(TouristPlaceString, TouristPlace::class.java)

    }

}