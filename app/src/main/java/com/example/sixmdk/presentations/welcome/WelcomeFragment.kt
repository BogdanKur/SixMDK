package com.example.sixmdk.presentations.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.cryptoproxy.coinmining.common.utils.views.doOnApplyWindowInsets
import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSource
import com.example.sixmdk.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    @Inject
    lateinit var registrationLocalDataSource: RegistrationLocalDataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
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
        val userData = registrationLocalDataSource.getUser()
        if(userData != null) binding.nameUser.text = userData.name


    }
}