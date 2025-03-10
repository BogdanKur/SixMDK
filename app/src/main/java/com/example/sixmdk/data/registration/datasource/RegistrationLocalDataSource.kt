package com.example.sixmdk.data.registration.datasource

import com.example.sixmdk.domain.registration.model.UserModel
import com.tencent.mmkv.MMKV
import javax.inject.Inject

interface RegistrationLocalDataSource {
    fun getName(): String?
    fun setName(user: String)
    fun isAuth(): Boolean
}
class RegistrationLocalDataSourceImpl @Inject constructor(): RegistrationLocalDataSource {
    val storage by lazy {
        MMKV.mmkvWithID(
            "RegistrationLocalDataSource",
            MMKV.MULTI_PROCESS_MODE
        )
    }
    override fun getName(): String? = storage.decodeString("user", null)

    override fun setName(user: String) {
        storage.encode("user", user)
    }

    override fun isAuth(): Boolean {
        return getName()!= null
    }

}