package com.josuelassey.testuser.retrofit.interfaces

import com.josuelassey.testuser.remote_model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfaceUser {
    @GET("users")
    fun getUsers(): Call<List<User>>
}