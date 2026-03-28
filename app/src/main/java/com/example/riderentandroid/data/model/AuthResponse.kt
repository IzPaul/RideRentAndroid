package com.example.riderentandroid.data.model

data class AuthResponse(
    val token: String,
    val type: String = "Bearer",
    val email: String
)
