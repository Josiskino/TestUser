package com.josuelassey.testuser.retrofit.client

import com.google.gson.GsonBuilder
import com.josuelassey.testuser.retrofit.interfaces.ApiInterfaceUser
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientUser {
    var BASE_URl : String = "https://jsonplaceholder.typicode.com/"
    val getClientUser: ApiInterfaceUser
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiInterfaceUser::class.java)
        }
}