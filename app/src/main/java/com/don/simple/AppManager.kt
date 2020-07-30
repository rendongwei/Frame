package com.don.simple

import android.app.Application
import com.don.frame.manager.BaseAppManager

class AppManager private constructor(): BaseAppManager() {

    companion object {

        @Volatile
        private var mManager: AppManager? = null

        @Synchronized
        fun getInstance(): AppManager {
            mManager = mManager ?: AppManager()
            return mManager!!
        }
    }

    override fun init(application: Application) {
        super.init(application)
        println(mApplicationContext.packageName)
    }

}