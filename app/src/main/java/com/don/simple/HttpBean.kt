package com.jinrongwealth.duriantree.bean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

data class HttpBean(
    var code: String,
    var status: Int,
    var msg: String,
    var success: Boolean,
    var data: Any
) : Serializable {

    inline fun <reified T> toBean(): T? {
        var json = Gson().toJson(data)
        return Gson().fromJson(json, object : TypeToken<T>() {}.type)
    }
}