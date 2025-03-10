package com.example.sixmdk.data.registration.datasource

import com.example.sixmdk.domain.registration.model.UserModel
import com.tencent.mmkv.MMKV
import javax.inject.Inject

interface RegistrationLocalDataSource {
    fun getUser(): UserModel?
    fun setUser(user: UserModel)
    fun isAuth(): Boolean
}
class RegistrationLocalDataSourceImpl @Inject constructor(): RegistrationLocalDataSource {
    val storage by lazy {
        MMKV.mmkvWithID(
            "RegistrationLocalDataSource",
            MMKV.MULTI_PROCESS_MODE
        )
    }
    override fun getUser(): UserModel? = storage.decodeParcelable("user", null)

    override fun setUser(user: UserModel) {
        storage.encode("user", user)
    }

    override fun isAuth(): Boolean {
        return getUser()!= null
    }

}