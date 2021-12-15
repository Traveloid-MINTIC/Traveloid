package com.traveloiddevs.cundinamarcago.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.traveloiddevs.cundinamarcago.R
import com.traveloiddevs.cundinamarcago.databinding.LoginFragmentBinding
import com.traveloiddevs.cundinamarcago.databinding.RegisterFragmentBinding
import com.traveloiddevs.cundinamarcago.login.LoginViewModel

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerBinding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = RegisterFragmentBinding.inflate(inflater, container, false)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        return registerBinding.root
    }



}