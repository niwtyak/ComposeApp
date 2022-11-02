package com.example.matelial2app.models

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    @SerializedName("users")
    val users: List<User>
)