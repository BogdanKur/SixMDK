package com.example.sixmdk.presentations.app

import android.app.Application
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
    companion object {
        const val MAPKIT_API_KEY = "b20f7b33-fb90-43e7-ba45-a9c83caa8e35"
    }
}