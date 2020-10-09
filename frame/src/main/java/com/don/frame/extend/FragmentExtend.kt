package com.don.frame.extend

import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.don.frame.data.MemoryCache
import com.don.frame.data.SharedPreference
import com.don.frame.util.ToastUtil

// 获取显示指标
fun Fragment.getDisplayMetrics() = context!!.getDisplayMetrics()

// 获取屏幕宽度
fun Fragment.getScreenWidth() = context!!.getScreenWidth()

// 获取屏幕高度
fun Fragment.getScreenHeight() = context!!.getScreenHeight()

// 获取屏幕密度
fun Fragment.getScreenDensity() = context!!.getScreenDensity()

// 获取屏幕密度Dpi
fun Fragment.getScreenDensityDpi() = context!!.getScreenDensityDpi()

// 获取屏幕尺度密度
fun Fragment.getScreenScaleDensity() = context!!.getScreenScaleDensity()

// dip转px
fun Fragment.dip2px(value: Float) = context!!.dip2px(value)

// px转dip
fun Fragment.px2dip(value: Float) = context!!.px2dip(value)

// sp转px
fun Fragment.sp2px(value: Float) = context!!.sp2px(value)

// px转sp
fun Fragment.px2sp(value: Float) = context!!.px2sp(value)

// 获取color
fun Fragment.color(@ColorRes id: Int) = context!!.color(id)

// 获取color
fun Fragment.color(color: String) = context!!.color(color)

// 获取drawable
fun Fragment.drawable(@DrawableRes id: Int) = context!!.drawable(id)

// 获取string
fun Fragment.string(@StringRes id: Int) = getString(id)

// 获取layout
fun Fragment.layout(@LayoutRes id: Int) = context!!.layout(id)

// 获取layout
fun Fragment.layout(@LayoutRes id: Int, parent: ViewGroup?, attachToRoot: Boolean) =
    context!!.layout(id, parent, attachToRoot)

// 显示toast
fun Fragment.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
    ToastUtil.showToast(context!!, text, duration)

// 获取SharedPreference
fun Fragment.sharedPreference() = SharedPreference.getInstance()

// 获取memoryCache
fun Fragment.memoryCache() = MemoryCache.getInstance()
