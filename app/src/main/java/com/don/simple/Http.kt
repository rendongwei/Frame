package com.don.simple

import com.don.frame.manager.BaseHttpManager
import retrofit2.converter.gson.GsonConverterFactory

class Http : BaseHttpManager() {
    private val mRetrofit by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        createRetrofit(
            "https://api.iworks.cn",
            createHttpClient(),
            GsonConverterFactory.create(createGson())
        )
    }
    val mService by lazy {
        createService(mRetrofit, ApiService::class.java)
    }

    companion object {

        @Volatile
        private var mManager: Http? = null

        @Synchronized
        fun getInstance(): Http {
            mManager = mManager ?: Http()
            return mManager!!
        }
    }
}

