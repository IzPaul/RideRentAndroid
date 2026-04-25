package com.example.riderentandroid.core.screens.login

interface LoginContract {
    interface LoginView {
        fun onLoginSuccessMessage()
        fun onLoginErrorMessage(error: String)
        fun navigateToHomeScreen()
    }

    interface LoginPresenter {
        fun login(username: String, password: String)
    }
}