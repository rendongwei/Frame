package com.don.frame.glide

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

@GlideModule
open class CustomGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        var options: RequestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .skipMemoryCache(true)
            .format(DecodeFormat.PREFER_RGB_565)
            .override(Target.SIZE_ORIGINAL)
        builder.setDefaultRequestOptions(options)
        var diskCacheSizeBytes: Long = 500 * 1024 * 1024
        var path: String = context.externalCacheDir!!.path + "/image"
        builder.setDiskCache(DiskLruCacheFactory(path, diskCacheSizeBytes))
        builder.setMemoryCache(LruResourceCache(20 * 1024 * 1024))
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}