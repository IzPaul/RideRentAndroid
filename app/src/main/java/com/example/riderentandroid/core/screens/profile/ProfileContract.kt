package com.example.riderentandroid.core.screens.profile

import com.example.riderentandroid.core.data.UserInfo

interface ProfileContract {
    interface View {
        fun DisplayUserInfo(user: UserInfo)
    }
    interface Presenter{

    }
}