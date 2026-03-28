package com.example.riderentandroid.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riderentandroid.api.RetrofitClient
import com.example.riderentandroid.data.model.UserProfileResponse
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val userProfile = MutableLiveData<UserProfileResponse?>()
    val errorMessage = MutableLiveData<String>()

    fun fetchProfile(email: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getProfile(email)
                if (response.isSuccessful) {
                    userProfile.postValue(response.body())
                } else {
                    errorMessage.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                errorMessage.postValue("Connection Failed: ${e.localizedMessage}")
            }
        }
    }
}