package com.traveloiddevs.cundinamarcago.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.traveloiddevs.cundinamarcago.R
import com.traveloiddevs.cundinamarcago.preference.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val fm : FragmentManager = supportFragmentManager
        val ft :FragmentTransaction= fm.beginTransaction()

        return when(item.itemId){
            R.id.preferences_menu ->{
                val fragmentSettings = SettingsFragment()
                ft.replace(R.id.fragmentContainerView,fragmentSettings).commit()
                ft.addToBackStack(null)
                true
            }
            android.R.id.home ->{
                onBackPressed()
                true
            }
            R.id.menu_sign_out ->{
                var auth: FirebaseAuth = Firebase.auth
                auth.signOut()
                //findNavController().navigate(R.id.loginFragment)
                true
            }
            else -> { return true }
        }
    }
    fun showIcon(){
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun hideIcon(){
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }
}