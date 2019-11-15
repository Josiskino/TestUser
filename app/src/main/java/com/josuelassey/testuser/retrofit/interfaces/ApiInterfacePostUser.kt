package com.josuelassey.testuser.retrofit.interfaces

import com.josuelassey.testuser.remote_model.PostUser
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfacePostUser {
    @GET("posts")
    fun getPostUser(): Call<List<PostUser>>
}