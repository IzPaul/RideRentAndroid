package com.example.riderentandroid.core.data

data class UserInfo(
    var email: String = "sample",
    var password: String = "",
    var firstName: String = "samplefirstname",
    var lastName: String = "samplelastname"
)

data class Vehicles(
    var model: String = ""
)