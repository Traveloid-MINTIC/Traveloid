package com.traveloiddevs.cundinamarcago.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth
    fun login(email: String, password: String) {
        //Iniciar Autenticación
        auth = Firebase.auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login", "signInWithEmail:success")

                } else {
                    Log.w("Login", "signInWithEmail:failure", task.exception)

                }
            }


    }

}