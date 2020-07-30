package com.don.frame.core.base.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.don.frame.core.base.activity.BaseActivity
import com.don.frame.util.LogUtil

class BaseApplication : Application() {

    companion object {
        val TAG = "Application"
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                LogUtil.log(BaseActivity.TAG, "onCreate: " + p0::class.java.canonicalName)
            }

            override fun onActivityStarted(p0: Activity) {
                LogUtil.log(BaseActivity.TAG, "onActivityStarted: " + p0::class.java.canonicalName)
            }

            override fun onActivityResumed(p0: Activity) {
                LogUtil.log(BaseActivity.TAG, "onActivityResumed: " + p0::class.java.canonicalName)
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                LogUtil.log(BaseActivity.TAG, "onActivitySaveInstanceState: " + p0::class.java.canonicalName)
            }

            override fun onActivityPaused(p0: Activity) {
                LogUtil.log(BaseActivity.TAG, "onActivityPaused: " + p0::class.java.canonicalName)
            }

            override fun onActivityStopped(p0: Activity) {
                LogUtil.log(BaseActivity.TAG, "onActivityStopped: " + p0::class.java.canonicalName)
            }

            override fun onActivityDestroyed(p0: Activity) {
                LogUtil.log(BaseActivity.TAG, "onActivityDestroyed: " + p0::class.java.canonicalName)
            }
        })
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtil.log(TAG, "onLowMemory")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        LogUtil.log(TAG, "onTrimMemory-$level")
    }

    override fun onTerminate() {
        super.onTerminate()
        LogUtil.log(TAG, "onTerminate")
    }
}