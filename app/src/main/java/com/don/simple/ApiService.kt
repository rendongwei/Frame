package com.don.simple

import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login/loginService/phoneIsRegister")
    suspend fun login(@Body body: JsonObject): Weather

}