package com.don.frame.extend

import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.don.frame.data.MemoryCache
import com.don.frame.data.SharedPreference
import com.don.frame.util.ToastUtil

// 获取显示指标
fun AppCompatActivity.getDisplayMetrics() = baseContext.getDisplayMetrics()

// 获取屏幕宽度
fun AppCompatActivity.getScreenWidth() = baseContext.getScreenWidth()

// 获取屏幕高度
fun AppCompatActivity.getScreenHeight() = baseContext.getScreenHeight()

// 获取屏幕密度
fun AppCompatActivity.getScreenDensity() = baseContext.getScreenDensity()

// 获取屏幕密度Dpi
fun AppCompatActivity.getScreenDensityDpi() = baseContext.getScreenDensityDpi()

// 获取屏幕尺度密度
fun AppCompatActivity.getScreenScaleDensity() = baseContext.getScreenScaleDensity()

// dip转px
fun AppCompatActivity.dip2px(value: Float) = baseContext.dip2px(value)

// px转dip
fun AppCompatActivity.px2dip(value: Float) = baseContext.px2dip(value)

// sp转px
fun AppCompatActivity.sp2px(value: Float) = baseContext.sp2px(value)

// px转sp
fun AppCompatActivity.px2sp(value: Float) = baseContext.px2sp(value)

// 获取color
fun AppCompatActivity.color(@ColorRes id: Int) = baseContext.color(id)

// 获取color
fun AppCompatActivity.color(color: String) = baseContext.color(color)

// 获取drawable
fun AppCompatActivity.drawable(@DrawableRes id: Int) = baseContext.drawable(id)

// 获取string
fun AppCompatActivity.string(@StringRes id: Int) = baseContext.getString(id)

// 获取layout
fun AppCompatActivity.layout(@LayoutRes id: Int) = baseContext.layout(id)

// 获取layout
fun AppCompatActivity.layout(@LayoutRes id: Int, parent: ViewGroup?, attachToRoot: Boolean) =
    baseContext.layout(id, parent, attachToRoot)

// 显示toast
fun AppCompatActivity.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
    ToastUtil.showToast(baseContext, text, duration)

// 获取SharedPreference
fun AppCompatActivity.sharedPreference() = SharedPreference.getInstance()

// 获取memoryCache
fun AppCompatActivity.memoryCache() = MemoryCache.getInstance()
