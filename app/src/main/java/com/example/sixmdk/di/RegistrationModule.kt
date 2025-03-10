package com.example.sixmdk.di

import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSource
import com.example.sixmdk.data.registration.datasource.RegistrationLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RegistrationModule {

    @Binds
    abstract fun bindRegistrationLocalDataSource(
        registrationLocalDataSourceImpl: RegistrationLocalDataSourceImpl
    ): RegistrationLocalDataSource
}