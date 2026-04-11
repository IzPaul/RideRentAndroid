package com.example.riderentandroid.core.screens.login

import android.app.Activity
import com.example.riderentandroid.core.models.LoginRequest
import com.example.riderentandroid.core.network.RiderentApi
import kotlinx.coroutines.*

class LoginPresenter(
    private val view: LoginContract.View,
    private val api: RiderentApi,
    private val loginRequest: LoginRequest
) : LoginContract.Presenter {

    private val scope = CoroutineScope(Dispatchers.IO + Job())
    private var isLoggedIn = false

    override fun login(email: String, pass: String) {

        scope.launch {
            try {
                val request = LoginRequest(email, pass)
                val response = api.login(request)

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        view.onLoginSuccess(response.body() ?: "Login Successful")
                    } else {
                        view.onLoginError("Invalid email or password")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view.onLoginError("Connection failed: ${e.message}")
                }
            }
        }
    }
}