package com.example.sixmdk.presentations.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.fragment.findNavController
import com.cryptoproxy.coinmining.common.utils.views.doOnApplyWindowInsets
import com.example.sixmdk.NavGraphDirections
import com.example.sixmdk.R
import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSource
import com.example.sixmdk.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    @Inject
    lateinit var registrationLocalDataSource: RegistrationLocalDataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.doOnApplyWindowInsets { view, insets, rect ->
            view.updatePadding(
                top = rect.top + insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                bottom = rect.bottom + insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            )
            insets
        }
        Handler(Looper.getMainLooper()).postDelayed( {
            if(registrationLocalDataSource.isAuth()) findNavController().navigate(NavGraphDirections.startWelcomeFragment())
            else findNavController().navigate(NavGraphDirections.startRegistrationFragment())
        }, 1500)
    }
}