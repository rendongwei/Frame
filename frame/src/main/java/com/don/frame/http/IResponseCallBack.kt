package com.don.frame.http

interface IResponseCallBack<T> {

    fun onStart()

    fun onSuccess(result: T)

    fun onFailure(result: T)

    fun onError(msg: String, code: Int)

    fun onComplete()

}