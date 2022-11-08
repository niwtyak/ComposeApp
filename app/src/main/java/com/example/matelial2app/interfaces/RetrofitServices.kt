package com.example.matelial2app.interfaces

import com.example.matelial2app.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitServices {


    @GET("users/all")
    suspend fun getUsers(): Response<UsersResponse>

    @Headers("Content-Type: application/json")
    @POST("login")
    suspend fun login(@Body loginInfo: LoginInfo): Response<UserKeys>

    @Headers("Content-Type: application/json")
    @POST("register")
    suspend fun register(@Body userdata: UserRegister): Response<User>

}