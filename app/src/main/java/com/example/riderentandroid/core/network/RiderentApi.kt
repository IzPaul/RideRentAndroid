package com.example.riderentandroid.core.network


import com.example.riderentandroid.core.models.LoginRequest
import com.example.riderentandroid.core.models.MessageResponse
import com.example.riderentandroid.core.models.RegisterRequest
import com.example.riderentandroid.core.models.UpdateProfileRequest
import com.example.riderentandroid.core.models.UserProfileResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface RiderentApi {
    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<String>

    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<String>

    @GET("api/user/profile")
    suspend fun getProfile(@Query("email") email: String): Response<UserProfileResponse>

    @PUT("api/user/profile")
    suspend fun updateProfile(
        @Query("email") email: String,
        @Body request: UpdateProfileRequest
    ): Response<MessageResponse>

    @Multipart
    @POST("api/user/upload-image/{email}")
    suspend fun uploadImage(
        @Path("email") email: String,
        @Part file: MultipartBody.Part
    ): Response<String>
}