package com.example.sixmdk.presentations.main.view

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
import com.example.sixmdk.databinding.FragmentOrderTaxiBinding
import com.example.sixmdk.presentations.main.viewmodel.ChooseViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OrderTaxiFragment : Fragment() {
    private lateinit var binding: FragmentOrderTaxiBinding
    private val model: ChooseViewModel by viewModels()
    private var car = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderTaxiBinding.inflate(inflater, container, false)
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
        binding.economLayout.setOnClickListener {
            car = "Эконом"
        }
        binding.comfortLayout.setOnClickListener {
            car = "Комфорт"
        }
        binding.kidsLayout.setOnClickListener {
            car = "Kids"
        }


        binding.orderTaxiBtn.setOnClickListener {
            model.setStartPoint(binding.fromRouteInput.text.toString())
            model.setEndPoint(binding.toRouteInput.text.toString())
            model.setCar(car)
            findNavController().navigate(NavGraphDirections.startWelcomeFragment())
        }

    }

}