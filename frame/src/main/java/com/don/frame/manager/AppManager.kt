package com.don.frame.manager

import android.app.Application
import android.content.Context
import com.don.frame.util.LogUtil

open class BaseAppManager {

    lateinit var mApplication: Application
    lateinit var mApplicationContext: Context

    companion object {
        val TAG = "AppManager"
    }

    open fun init(application: Application) {
        LogUtil.log(TAG, "init: ${application.packageName}")
        mApplication = application
        mApplicationContext = application.applicationContext
    }
}