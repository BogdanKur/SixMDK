package com.example.sixmdk.domain.registration.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class UserModel(
    val name: String,
    val surname: String,
    val number: String
): Parcelable
