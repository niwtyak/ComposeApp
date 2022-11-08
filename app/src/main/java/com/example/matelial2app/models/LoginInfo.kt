package com.example.matelial2app.models

import com.google.gson.annotations.SerializedName

data class LoginInfo(
    @SerializedName("name")
    val name:String,
    @SerializedName("password")
    val password:String,
) {
}