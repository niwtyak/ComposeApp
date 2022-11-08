package com.example.matelial2app.models

import com.google.gson.annotations.SerializedName

data class UserKeys(
    @SerializedName("access_token")
    val accessKey: String,
    @SerializedName("refresh_token")
    val refreshKey: String
) {
}