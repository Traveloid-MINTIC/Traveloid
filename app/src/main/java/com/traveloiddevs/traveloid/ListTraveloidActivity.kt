package com.traveloiddevs.traveloid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListTraveloidActivity : AppCompatActivity() {
    private lateinit var touristPlacesList: ArrayList<TouristPlace>
    private lateinit var touristPlacesAdapter: TouristPlacesAdapter
    private lateinit var touristPlacesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_traveloid)

        touristPlacesRecyclerView = findViewById(R.id.traveloid_recicler_view)

        touristPlacesList = createMockTouristPlaces()

        touristPlacesAdapter = TouristPlacesAdapter(touristPlacesList)

        /*
        touristPlacesRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        */

        touristPlacesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristPlacesAdapter
            setHasFixedSize(false)
        }
    }
    private fun createMockTouristPlaces(): ArrayList<TouristPlace>{

        return arrayListOf(
            TouristPlace(
                name = "Monserrate",
                elevation = "3152 MSNM",
                weather = "18°C",
                ratingStart = "4",
                description = "El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Los cerros de Bogotá tienen por lo menos 16 millones de años de antigüedad. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad",
                descriptionCard = "El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá reconocido por la fe de su Santuario, sus jardines y fuentes, su gastronomía, sus bosques de niebla, sus atardeceres, y noches estrelladas.",
                history = "Hacia el año 1620 la Familia Fernández Valenzuela construyó las primeras ermitas en el cerro. Fué Pedro Fernández quién edificó la capilla en homenaje a la Santa Cruz de Monserrate. El Santuario del Señor Caído de Monserrate con un estilo neolítico fue diseñado  por Arturo Jaramillo y terminado alrededor del año 1925",
                restaurants = "Restaurante Casa San Isidro y Restaurante Casa Santa Clara",
                location = "Mapa"),
            TouristPlace(
                name = "Parque Jaime Duque",
                elevation = "2600 MSNM",
                weather = "19°C",
                ratingStart = "5",
                description = "Por defecto",
                descriptionCard = "Por defecto",
                history = "Por defecto",
                restaurants = "Por defecto",
                location = "Mapa"),
            TouristPlace(
                name = "Mina de Sal de Zipaquira",
                elevation = "--- MSNM",
                weather = "19°C",
                ratingStart = "3",
                description = "Por defecto",
                descriptionCard = "Por defecto",
                history = "Por defecto",
                restaurants = "Por defecto",
                location = "Mapa")
        )
    }
}