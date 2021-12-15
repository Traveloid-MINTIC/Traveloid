package com.traveloiddevs.cundinamarcago.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.traveloiddevs.cundinamarcago.data.TouristplacesRepository
import com.traveloiddevs.cundinamarcago.model.TouristPlace
import com.traveloiddevs.cundinamarcago.model.TouristPlaceItem
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var touristPlacesLoad : MutableLiveData<ArrayList<TouristPlaceItem>> = MutableLiveData()
    val onTouristPlacesLoaded : LiveData<ArrayList<TouristPlaceItem>> = touristPlacesLoad

    private val repository = TouristplacesRepository()

    @DelicateCoroutinesApi
    fun getTouristplacesFromServer(){
        GlobalScope.launch ( Dispatchers.IO ) {
            touristPlacesLoad.postValue(repository.getTouristPlaces())
        }
    }

    fun loadMockTouristPlacesFromJson(TouristPlacesString: InputStream?) {
        val TouristPlaceString= TouristPlacesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        touristPlacesLoad.value = gson.fromJson(TouristPlaceString, TouristPlace::class.java)

    }

}
