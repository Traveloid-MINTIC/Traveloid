package com.traveloiddevs.cundinamarcago.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private var userCreate : MutableLiveData<Boolean> = MutableLiveData()
    val onUserCreate : LiveData<Boolean> = userCreate

    fun register(email: String, password: String) {

        // Initialize Firebase Auth
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)

            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    userCreate.value = true
                    Log.d("Estado Registro", "createUserWithEmail:success")


                } else {
                    userCreate.value = false
                    Log.w(" Estado Registro", "createUserWithEmail:failure", task.exception)

                }
            }
    }


}