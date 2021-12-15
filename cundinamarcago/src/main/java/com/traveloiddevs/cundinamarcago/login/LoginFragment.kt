package com.traveloiddevs.cundinamarcago.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.traveloiddevs.cundinamarcago.R
import com.traveloiddevs.cundinamarcago.databinding.FragmentMapsBinding
import com.traveloiddevs.cundinamarcago.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginBinding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = LoginFragmentBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        return loginBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(loginBinding){
            loginButton.setOnClickListener{
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                loginViewModel.login(email, password)
            }
        }
    }

}