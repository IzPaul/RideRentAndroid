package com.example.riderentandroid.core.models

data class AuthResponse(
    val token: String,
    val type: String = "Bearer",
    val email: String
)
