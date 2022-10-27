package com.example.matelial2app.interfaces
import com.example.matelial2app.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitServices {

    @GET("users/all")
    fun getUsers(): Call<MutableList<User>>

    @POST("login")
    fun login():Call<Pair<String,String>>

    @POST("register")
    fun register():Call<User>

}