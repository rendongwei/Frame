package com.don.frame.data

import android.util.LruCache
import com.don.frame.util.LogUtil

class MemoryCache private constructor() {

    private val mLruCaches = hashMapOf<String, LruCache<String, Any>>()

    companion object {

        val TAG = "MemoryCache"

        @Volatile
        private var mMemoryCache: MemoryCache? = null

        @Synchronized
        fun getInstance(): MemoryCache {
            mMemoryCache = mMemoryCache ?: MemoryCache()
            return mMemoryCache!!
        }
    }

    // 根据数据类型创建LruCache
    private fun createLruCache(): LruCache<String, Any> {
        var maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        var cacheMemory = maxMemory / 8
        return LruCache(cacheMemory)
    }

    // 获取对应类型的LruCache
    fun getLruCache(type: String): LruCache<String, Any> {
        if (!mLruCaches.containsKey(type)) {
            mLruCaches[type] = createLruCache()
            LogUtil.log(TAG, "createLruCache: $type")
        }
        return mLruCaches[type]!!
    }

    // 添加数据
    inline fun <reified T> put(key: String, value: T) {
        if (key.isNullOrBlank()) {
            return
        }
        var cls = T::class.java
        var cache = getLruCache(cls.canonicalName!!)
        cache.put(key, value)
        LogUtil.log(TAG, "put: ${cls.name} $key = $value")
    }

    // 获取数据
    inline fun <reified T> get(key: String): T? {
        if (key.isNullOrBlank()) {
            return null
        }
        var cls = T::class.java
        var cache = getLruCache(cls.canonicalName!!)
        var value = cache.get(key)?.run {
            this as T?
        }
        LogUtil.log(TAG, "get: ${cls.name} $key = $value")
        return value
    }

    // 删除某个数据
    inline fun <reified T> remove(key: String) {
        if (key.isNullOrBlank()) {
            return
        }
        var cls = T::class.java
        var cache = getLruCache(cls.canonicalName!!)
        cache.remove(key)
        LogUtil.log(TAG, "remove: ${cls.name} $key")
    }

    // 清空某种类型的数据
    inline fun <reified T> clear() {
        var cls = T::class.java
        var cache = getLruCache(cls.canonicalName!!)
        cache.evictAll()
        LogUtil.log(TAG, "clear: ${cls.name}")
    }

    // 清空所有数据
    fun clearAll() {
        for ((k, v) in mLruCaches) {
            v.evictAll()
            LogUtil.log(TAG, "clearAll: $k")
        }
        mLruCaches.clear()
        LogUtil.log(TAG, "clearAll")
    }
}