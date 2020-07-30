package com.don.frame.http

import com.don.frame.util.LogUtil
import com.google.gson.JsonParseException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

object HttpExceptionUtil {

    private val TAG = "HttpManagerError"

    fun handleException(e: Throwable): String {
        LogUtil.log(TAG, e.message.toString())
        return when {
            (e is HttpException || e is SocketTimeoutException || e is ConnectException || e is UnknownHostException) -> "网络错误"
            (e is JsonParseException || e is JSONException || e is ParseException) -> "数据解析错误"
            (e is IllegalArgumentException) -> "服务器错误"
            else -> "未知错误"
        }
    }

    fun getHttpErrorCode(e: Throwable): Int {
        if (e is HttpException) {
            return e.code()
        }
        return -1
    }
}