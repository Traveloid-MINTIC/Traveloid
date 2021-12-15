package com.traveloiddevs.cundinamarcago.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth
    private var userLogin : MutableLiveData<Boolean> = MutableLiveData()
    val onUserLoggedIn : LiveData<Boolean> = userLogin

    fun login(email: String, password: String) {

        auth = Firebase.auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    userLogin.value = true
                        Log.d("Login", "signInWithEmail:success")

                } else {
                    userLogin.value = false
                    Log.w("Login", "signInWithEmail:failure", task.exception)

                }
            }


    }

}