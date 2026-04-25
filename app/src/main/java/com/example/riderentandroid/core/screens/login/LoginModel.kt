package com.example.riderentandroid.core.screens.login

class LoginModel {
    private val username = "test"
    private val password = "test"

    // call login api / local database
    // clean data
    // decide true or false
    //return result of calling login api with LoginRequest
    fun login(username: String, password: String): Boolean {
        val isUsernameCorrect = username.equals(this.username, ignoreCase = false)
        val isPasswordCorrect = password.equals(this.password, ignoreCase = false)

        return isUsernameCorrect && isPasswordCorrect
    }
}