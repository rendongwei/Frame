package com.don.frame.data

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.don.frame.util.LogUtil

class SharedPreference private constructor() {

    val TAG = "SharedPreference"

    companion object {

        @Volatile
        private var mSharedPreference: SharedPreference? = null

        @Synchronized
        fun getInstance(): SharedPreference {
            mSharedPreference = mSharedPreference ?: SharedPreference()
            return mSharedPreference!!
        }
    }

    fun getSharedPreferences(context: Context): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun put(context: Context, key: String, value: Any) {
        if (key.isNullOrBlank()) {
            return
        }
        var sp = getSharedPreferences(context)
        sp?.run {
            LogUtil.log(TAG, "put: key:$key value:$value")
            when (value) {
                is Int -> edit().putInt(key, value).apply()
                is Float -> edit().putFloat(key, value).apply()
                is Double -> edit().putFloat(key, value.toFloat()).apply()
                is Long -> edit().putLong(key, value).apply()
                is Boolean -> edit().putBoolean(key, value).apply()
                is String -> edit().putString(key, value).apply()
            }
        }
    }

    inline fun <reified T> get(context: Context, key: String): T? {
        if (key.isNullOrBlank()) {
            return null
        }
        var sp = getSharedPreferences(context)
        sp?.apply {
            var isExist = contains(key)
            if (isExist) {
                var value = when (T::class) {
                    Int::class -> sp.getInt(key, 0) as T?
                    Float::class -> sp.getFloat(key, 0f) as T?
                    Double::class -> sp.getFloat(key, 0f).toDouble() as T?
                    Long::class -> sp.getLong(key, 0) as T?
                    Boolean::class -> sp.getBoolean(key, false) as T?
                    String::class -> sp.getString(key, null) as T?
                    else -> {
                        null
                    }
                }
                LogUtil.log(TAG, "get: key:$key value:$value")
                return value
            }
        }
        LogUtil.log(TAG, "get: key:$key value:null")
        return null
    }

    fun remove(context: Context, key: String) {
        if (key.isNullOrBlank()) {
            return
        }
        var sp = getSharedPreferences(context)
        sp?.apply {
            LogUtil.log(TAG, "remove: key:$key")
            sp.edit().remove(key).apply()
        }
    }

    fun clear(context: Context) {
        var sp = getSharedPreferences(context)
        sp?.apply {
            LogUtil.log(TAG, "clear")
            sp.edit().clear().apply()
        }
    }
}