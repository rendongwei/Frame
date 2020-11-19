package com.don.frame.extend

import com.don.frame.http.HttpExceptionUtil
import com.don.frame.http.IResponseCallBack
import com.don.frame.rxjava.scheduler.SchedulerUtils
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.addSubscribe(callback: IResponseCallBack<T>): Disposable {
    return this.compose(SchedulerUtils.ioToMain()).run {
        callback.onStart()
        subscribe({
            callback.onComplete()
            callback.onSuccess(it)
        }, {
            callback.onComplete()
            callback.onError(HttpExceptionUtil.handleException(it), HttpExceptionUtil.getHttpErrorCode(it))
        })
    }
}