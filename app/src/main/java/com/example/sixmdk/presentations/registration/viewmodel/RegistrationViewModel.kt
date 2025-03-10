package com.example.sixmdk.presentations.registration.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSource
import com.example.sixmdk.domain.registration.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationLocalDataSource: RegistrationLocalDataSource
): ViewModel() {
    fun signup(user: UserModel) {
        registrationLocalDataSource.setUser(user)
    }
}