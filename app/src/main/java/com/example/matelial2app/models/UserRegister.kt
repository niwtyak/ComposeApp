package com.example.matelial2app.models

import com.google.gson.annotations.SerializedName

data class UserRegister (

    @SerializedName("name")
    val name: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("role")
    val role: String
)
