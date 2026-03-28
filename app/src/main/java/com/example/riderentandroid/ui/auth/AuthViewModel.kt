package com.example.riderentandroid.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riderentandroid.api.RetrofitClient
import com.example.riderentandroid.data.model.LoginRequest
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    val loginStatus = MutableLiveData<String>()

    fun login(email: String, pass: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.login(LoginRequest(email, pass))
                if (response.isSuccessful) {
                    loginStatus.postValue("Welcome: ${response.body()}")
                } else {
                    loginStatus.postValue("Login Failed: ${response.code()}")
                }
            } catch (e: Exception) {
                loginStatus.postValue("Network Error: ${e.message}")
                println(e.message)
            }
        }
    }
}