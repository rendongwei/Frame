package com.don.simple

import com.don.frame.core.base.application.BaseApplication

class BaseApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        AppManager.getInstance().init(this)
    }
}