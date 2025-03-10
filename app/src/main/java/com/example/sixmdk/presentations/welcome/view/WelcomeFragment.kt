package com.example.sixmdk.presentations.welcome.view

import android.annotation.SuppressLint
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
import com.example.sixmdk.R
import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSource
import com.example.sixmdk.databinding.FragmentWelcomeBinding
import com.example.sixmdk.presentations.welcome.viewmodel.ShowRouteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private val model: ShowRouteViewModel by viewModels()

    @Inject
    lateinit var registrationLocalDataSource: RegistrationLocalDataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.doOnApplyWindowInsets { view, insets, rect ->
            view.updatePadding(
                top = rect.top + insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                bottom = rect.bottom + insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            )
            insets
        }
        binding.welcomeTitle.text = getString(R.string.welcome) + " " + registrationLocalDataSource.getName() +
                " " + registrationLocalDataSource.getSurname() + "!"
        if (model.getStartPoint() != null)
            binding.startInput.text = getString(R.string.start) + " " + model.getStartPoint()
        if (model.getEndPoint() != null)
            binding.endInput.text = getString(R.string.end) + " " + model.getEndPoint()
        if (model.getCar() != null)
            binding.carInput.text = getString(R.string.car) + " " + model.getCar()
        binding.orderTaxiBtn.setOnClickListener {
            findNavController().navigate(NavGraphDirections.startMainFragment())
        }
    }
}