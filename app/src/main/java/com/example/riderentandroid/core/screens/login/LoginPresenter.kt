package com.example.riderentandroid.core.screens.login

import com.example.riderentandroid.R
import android.app.Activity
import com.example.riderentandroid.core.app.RideRentApp
import com.example.riderentandroid.core.models.LoginRequest
import com.example.riderentandroid.core.network.RiderentApi
import kotlinx.coroutines.*
class LoginPresenter(
    private val view: LoginContract.LoginView,
    private val api: RiderentApi,
    //private val loginRequest: LoginRequest,
    private val loginModel: LoginModel
) : LoginContract.LoginPresenter {

    private val scope = CoroutineScope(Dispatchers.IO + Job())
    private var isLoggedIn = false

    override fun login(email: String, pass: String) {
        scope.launch {
            try {

                val response = loginModel.login(email,pass)
                if(response) {
                    isLoggedIn = true;
                    withContext(Dispatchers.Main) {
                        // app.setUserInfo(UserInfo(email, password))
                        view.onLoginSuccessMessage()
                        view.navigateToHomeScreen()
                    }
                }else{
                    view.onLoginErrorMessage("Invalid Credentials")
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view.onLoginErrorMessage("Connection failed: ${e.message}")
                }
            }
        }
    }
}


//                api.login(request)
//                withContext(Dispatchers.Main) {
//                    if (response.isSuccessful) {
//                        view.onLoginSuccess(response.body() ?: "Login Successful")
//                    } else {
//                        view.onLoginError("Invalid email or password")
//                    }
//                }