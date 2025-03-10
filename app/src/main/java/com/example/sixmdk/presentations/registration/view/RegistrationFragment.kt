package com.example.sixmdk.presentations.registration.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cryptoproxy.coinmining.common.utils.views.doOnApplyWindowInsets
import com.example.sixmdk.NavGraphDirections
import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSource
import com.example.sixmdk.databinding.FragmentRegistrationBinding
import com.example.sixmdk.domain.registration.model.UserModel
import com.example.sixmdk.presentations.common.view.showErrorSnackbar
import com.example.sixmdk.presentations.registration.viewmodel.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding
    private val model: RegistrationViewModel by viewModels()
    @Inject
    lateinit var registrationLocalDataSource: RegistrationLocalDataSource
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(registrationLocalDataSource.isAuth()) findNavController().navigate(NavGraphDirections.startWelcomeFragment())
        binding.root.doOnApplyWindowInsets { view, insets, rect ->
            view.updatePadding(
                top = rect.top + insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                bottom = rect.bottom + insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            )
            insets
        }
        binding.signupBtn.setOnClickListener {
            if(binding.nameInput.text.toString() != "" &&
                binding.surnameInput.text.toString() != "" &&
                binding.numberInput.text.toString() != "") {
                model.signup(binding.nameInput.text.toString())

                findNavController().navigate(NavGraphDirections.startWelcomeFragment())
            } else {
                binding.root.showErrorSnackbar("Введите все поля!!!")
            }
        }


    }
}