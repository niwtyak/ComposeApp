package com.example.matelial2app.interfaces
import com.example.matelial2app.models.User
import com.example.matelial2app.models.UsersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitServices {


    @GET("users/all")
    suspend fun getUsers(): Response<UsersResponse>

    @POST("login")
    fun login():Call<Pair<String,String>>

    @POST("register")
    fun register():Call<User>

}