package com.example.matelial2app.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Post(
    @SerializedName("id")
    val id:Int,
    @SerializedName("user_id")
    val user_id:Int,
    @SerializedName("content")
    val content:String,
    @SerializedName("dateCreated")
    val dateCreated:Date,
    @SerializedName("dateLstUpdated")
    val dateLastUpdated:Date
) {

}
