package com.example.sixmdk.data.welcome.datasource

import com.tencent.mmkv.MMKV
import javax.inject.Inject

interface WelcomeLocalDataSource {
    fun setStartPoint(start: String)
    fun getStartPoint(): String?

    fun setEndPoint(end: String)
    fun getEndPoint(): String?

    fun setCar(car: String)
    fun getCar(): String?

}

class WelcomeLocalDataSourceImpl @Inject constructor(): WelcomeLocalDataSource {
    private val storage by lazy {
        MMKV.mmkvWithID(
            "WelcomeLocalDataSource",
            MMKV.MULTI_PROCESS_MODE
        )
    }
    override fun setStartPoint(start: String) {
        storage.encode("start", start)
    }

    override fun getStartPoint(): String? = storage.decodeString("start", null)

    override fun setEndPoint(end: String) {
        storage.encode("end", end)
    }

    override fun getEndPoint(): String? = storage.decodeString("end", null)

    override fun setCar(car: String) {
        storage.encode("car", car)
    }
    override fun getCar(): String? = storage.decodeString("car", null)

}