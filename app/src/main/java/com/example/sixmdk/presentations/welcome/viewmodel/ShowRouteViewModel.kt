package com.example.sixmdk.presentations.welcome.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sixmdk.data.welcome.datasource.WelcomeLocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowRouteViewModel @Inject constructor(
    private val welcomeLocalDataSource: WelcomeLocalDataSource
): ViewModel() {
    fun getStartPoint() = welcomeLocalDataSource.getStartPoint()
    fun getEndPoint() = welcomeLocalDataSource.getEndPoint()
    fun getCar() = welcomeLocalDataSource.getCar()
}