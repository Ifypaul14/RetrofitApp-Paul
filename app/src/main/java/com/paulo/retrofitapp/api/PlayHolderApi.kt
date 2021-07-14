package com.paulo.retrofitapp.api

import com.paulo.retrofitapp.model.User
import retrofit2.Call
import retrofit2.http.GET

interface PlayHolderApi {

    @GET("users")
   suspend fun getUsers(): List<User>
}