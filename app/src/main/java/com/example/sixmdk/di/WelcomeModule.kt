package com.example.sixmdk.di

import com.example.sixmdk.data.welcome.datasource.WelcomeLocalDataSource
import com.example.sixmdk.data.welcome.datasource.WelcomeLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WelcomeModule {

    @Binds
    abstract fun bindWelcomeLocalDataSource(
        welcomeLocalDataSourceImpl: WelcomeLocalDataSourceImpl
    ): WelcomeLocalDataSource
}