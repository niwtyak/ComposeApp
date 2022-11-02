package com.example.matelial2app.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("password")
    val password:String,
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: List<Post>
        ){

}

enum class Role{
    admin, creator, consumer
}
