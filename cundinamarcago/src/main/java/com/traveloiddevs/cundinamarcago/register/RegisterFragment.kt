package com.traveloiddevs.cundinamarcago.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.traveloiddevs.cundinamarcago.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerBinding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registerBinding = RegisterFragmentBinding.inflate(inflater, container, false)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        registerViewModel.onUserCreate.observe(viewLifecycleOwner,{ result ->
            onUserCreatedSubscribe(result)
        })
        return registerBinding.root
    }

    private fun onUserCreatedSubscribe(result: Boolean?) {
        result?.let { isRegister ->
            if(isRegister) {
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            }else
                Toast.makeText(context, "Registro Fallido", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(registerBinding){
            registerButton.setOnClickListener{
                val email = emailEditText.toString()
                val username = usernameEditText.toString()
                val password = passwordEditText.toString()
                val repeatPassword = repeatPasswordEditText.toString()

                registerViewModel.register( email, password )
            }

        }
    }

}