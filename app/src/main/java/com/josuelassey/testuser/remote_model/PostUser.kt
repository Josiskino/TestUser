package com.josuelassey.testuser.remote_model

import com.google.gson.annotations.SerializedName

data class PostUser(
    @SerializedName("userId")
    var userId : Int,
    @SerializedName("id")
    var id : Int,
    @SerializedName("title")
    var title : String,
    @SerializedName("body")
    var body : String
)