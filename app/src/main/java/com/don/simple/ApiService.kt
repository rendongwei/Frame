package com.don.simple

import com.google.gson.JsonObject
import com.jinrongwealth.duriantree.bean.HttpBean
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login/loginService/phoneIsRegister")
    suspend fun login(@Body body: JsonObject): HttpBean

}