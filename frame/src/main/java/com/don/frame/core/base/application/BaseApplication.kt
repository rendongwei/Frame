package com.don.frame.core.base.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.don.frame.util.LogUtil

class BaseApplication : Application() {

    val TAG = "Application"
    val TAG_ACTIVITY = "Activity"

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                LogUtil.log(TAG_ACTIVITY, "onCreate: " + p0::class.java.canonicalName)
            }

            override fun onActivityStarted(p0: Activity) {
                LogUtil.log(TAG_ACTIVITY, "onActivityStarted: " + p0::class.java.canonicalName)
            }

            override fun onActivityResumed(p0: Activity) {
                LogUtil.log(TAG_ACTIVITY, "onActivityResumed: " + p0::class.java.canonicalName)
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                LogUtil.log(TAG_ACTIVITY, "onActivitySaveInstanceState: " + p0::class.java.canonicalName)
            }

            override fun onActivityPaused(p0: Activity) {
                LogUtil.log(TAG_ACTIVITY, "onActivityPaused: " + p0::class.java.canonicalName)
            }

            override fun onActivityStopped(p0: Activity) {
                LogUtil.log(TAG_ACTIVITY, "onActivityStopped: " + p0::class.java.canonicalName)
            }

            override fun onActivityDestroyed(p0: Activity) {
                LogUtil.log(TAG_ACTIVITY, "onActivityDestroyed: " + p0::class.java.canonicalName)
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