package com.example.riderentandroid.core.app

import android.app.Application
import android.util.Log
import com.example.riderentandroid.core.data.UserInfo

class RideRentApp : Application() {
    val username = "test"
    val password = "test"

    private var userInfo = UserInfo()

    override fun onCreate() {
        super.onCreate()
        Log.e("RideRentApp", "RideRentApp:onCreate() is called")
    }

    fun getUserInfo() = this.userInfo

    fun setUserInfo(userInfo: UserInfo) {
        this.userInfo = userInfo
    }
}