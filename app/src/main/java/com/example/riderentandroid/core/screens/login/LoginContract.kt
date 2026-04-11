package com.example.riderentandroid.core.screens.login

interface LoginContract {
    interface View {
        fun onLoginSuccess(message: String)
        fun onLoginError(error: String)
    }

    interface Presenter {
        fun login(email: String, pass: String)
    }
}