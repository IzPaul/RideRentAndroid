package com.example.riderentandroid.core.models

data class RegisterRequest(val email:String, val password:String,
                           val fullName:String,val phone:String,
                           val address:String)
