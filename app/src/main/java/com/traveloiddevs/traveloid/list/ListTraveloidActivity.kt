package com.traveloiddevs.traveloid.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.traveloiddevs.traveloid.R
import com.traveloiddevs.traveloid.detail.DetailActivity
import com.traveloiddevs.traveloid.model.TouristPlace
import com.traveloiddevs.traveloid.model.TouristPlaceItem

class ListTraveloidActivity : AppCompatActivity() {
    private lateinit var touristPlacesList: ArrayList<TouristPlaceItem>
    private lateinit var touristPlacesAdapter: TouristPlacesAdapter
    private lateinit var touristPlacesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_traveloid)

        touristPlacesRecyclerView = findViewById(R.id.traveloid_recicler_view)

//        touristPlacesList = createMockTouristPlaces()
        touristPlacesList = loadMockTouristPlacesFromJson()
        touristPlacesAdapter = TouristPlacesAdapter(touristPlacesList, onItemClicked = {onTouristPlaceClicked(it)})

        val apply = touristPlacesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristPlacesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTouristPlaceClicked(touristplace: TouristPlaceItem) {
        Log.d("elevation",touristplace.elevation)
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("touristPlace", touristplace)
        startActivity(intent)

    }

    private fun loadMockTouristPlacesFromJson(): ArrayList<TouristPlaceItem> {
        val TouristPlacesString: String = applicationContext.assets.open("touristPlaces.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(TouristPlacesString, TouristPlace::class.java )
        return data
    }
    /*
    private fun createMockTouristPlaces(): ArrayList<TouristPlace>{

        return arrayListOf(

            /*
            Crear superheroe uno a uno
            var lista : ArrayList<TouristPlace> = arrayListOf()
            var touristPlace= TouristPlace(
                name = "Monserrate",
                elevation = "3152 MSNM",
                weather = "18??C",
                ratingStart = "4",
                description = "El cerro de Monserrate es el m??s conocido de los cerros Orientales de Bogot??. Los cerros de Bogot?? tienen por lo menos 16 millones de a??os de antig??edad. La bas??lica del Se??or de Monserrate ha sido lugar de peregrinaci??n religiosa desde la ??poca colonial y se constituye en un atractivo natural, religioso, gastron??mico de la ciudad",
                descriptionCard = "El cerro de Monserrate es el m??s conocido de los cerros Orientales de Bogot?? reconocido por la fe de su Santuario, sus jardines y fuentes, su gastronom??a, sus bosques de niebla, sus atardeceres, y noches estrelladas.",
                history = "Hacia el a??o 1620 la Familia Fern??ndez Valenzuela construy?? las primeras ermitas en el cerro. Fu?? Pedro Fern??ndez qui??n edific?? la capilla en homenaje a la Santa Cruz de Monserrate. El Santuario del Se??or Ca??do de Monserrate con un estilo neol??tico fue dise??ado  por Arturo Jaramillo y terminado alrededor del a??o 1925",
                restaurants = "Restaurante Casa San Isidro y Restaurante Casa Santa Clara",
                location = "Mapa",
                urlPicture = "https://media.tacdn.com/media/attractions-splice-spp-674x446/09/b7/b5/57.jpg"
            ),

            */
            TouristPlace(
                name = "Monserrate",
                elevation = "3152 MSNM",
                weather = "18??C",
                ratingStart = "4",
                description = "El cerro de Monserrate es el m??s conocido de los cerros Orientales de Bogot??. Los cerros de Bogot?? tienen por lo menos 16 millones de a??os de antig??edad. La bas??lica del Se??or de Monserrate ha sido lugar de peregrinaci??n religiosa desde la ??poca colonial y se constituye en un atractivo natural, religioso, gastron??mico de la ciudad",
                descriptionCard = "El cerro de Monserrate es el m??s conocido de los cerros Orientales de Bogot?? reconocido por la fe de su Santuario, sus jardines y fuentes, su gastronom??a, sus bosques de niebla, sus atardeceres, y noches estrelladas.",
                history = "Hacia el a??o 1620 la Familia Fern??ndez Valenzuela construy?? las primeras ermitas en el cerro. Fu?? Pedro Fern??ndez qui??n edific?? la capilla en homenaje a la Santa Cruz de Monserrate. El Santuario del Se??or Ca??do de Monserrate con un estilo neol??tico fue dise??ado  por Arturo Jaramillo y terminado alrededor del a??o 1925",
                restaurants = "Restaurante Casa San Isidro y Restaurante Casa Santa Clara",
                location = "Mapa",
                urlPicture = "https://media.tacdn.com/media/attractions-splice-spp-674x446/09/b7/b5/57.jpg"
            ),

            TouristPlace(
                name = "Parque Jaime Duque",
                elevation = "2600 MSNM",
                weather = "19??C",
                ratingStart = "5",
                description = "Por defecto",
                descriptionCard = "Por defecto",
                history = "Por defecto",
                restaurants = "Por defecto",
                location = "Mapa",
                urlPicture = "https://blog.redbus.co/wp-content/uploads/2018/04/jaime-duque-2.png"
            ),
            TouristPlace(
                name = "Mina de Sal de Zipaquira",
                elevation = "--- MSNM",
                weather = "19??C",
                ratingStart = "3",
                description = "Por defecto",
                descriptionCard = "Por defecto",
                history = "Por defecto",
                restaurants = "Por defecto",
                location = "Mapa" ,
                urlPicture = "https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_2000,h_1200/https://vagabundler.com/wp-content/uploads/2019/08/P1100032-Copy-2000x1200.jpg"
            ),
        )
    }
    */
}