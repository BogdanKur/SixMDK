package com.example.sixmdk.presentations.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sixmdk.data.welcome.datasource.WelcomeLocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseViewModel @Inject constructor(
    private val welcomeLocalDataSource: WelcomeLocalDataSource
): ViewModel() {
    fun setStartPoint(point: String) {
        welcomeLocalDataSource.setStartPoint(point)
    }

    fun setEndPoint(point: String) {
        welcomeLocalDataSource.setEndPoint(point)
    }

    fun setCar(car: String) {
        welcomeLocalDataSource.setCar(car)
    }
}