package com.don.frame.extend

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

// 获取显示指标
fun Context.getDisplayMetrics(): DisplayMetrics {
    return this.resources.displayMetrics
}

// 获取屏幕宽度
fun Context.getScreenWidth(): Int {
    return getDisplayMetrics().widthPixels
}

// 获取屏幕高度
fun Context.getScreenHeight(): Int {
    return getDisplayMetrics().heightPixels
}

// 获取屏幕密度
fun Context.getScreenDensity(): Float {
    return getDisplayMetrics().density
}

// 获取屏幕密度Dpi
fun Context.getScreenDensityDpi(): Int {
    return getDisplayMetrics().densityDpi
}

// 获取屏幕尺度密度
fun Context.getScreenScaleDensity(): Float {
    return getDisplayMetrics().scaledDensity
}

// dip转px
fun Context.dip2px(value: Float): Int {
    return (value * getScreenDensity() + 0.5f).toInt()
}

// px转dip
fun Context.px2dip(value: Float): Int {
    return (value / getScreenDensity() + 0.5f).toInt()
}

// sp转px
fun Context.sp2px(value: Float): Int {
    return (value * getScreenScaleDensity() + 0.5f).toInt()
}

// px转sp
fun Context.px2sp(value: Float): Int {
    return (value / getScreenScaleDensity() + 0.5f).toInt()
}

// 获取color
fun Context.color(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

// 获取color
fun Context.color(color: String): Int {
    return Color.parseColor(color)
}

// 获取drawable
fun Context.drawable(@DrawableRes id: Int): Drawable? {
    return getDrawable(id)
}

// 获取layout
fun Context.layout(@LayoutRes id: Int): View {
    return layout(id, null, false)
}

// 获取layout
fun Context.layout(@LayoutRes id: Int, parent: ViewGroup?, attachToRoot: Boolean): View {
    return LayoutInflater.from(this).inflate(id, parent, attachToRoot)
}

// context转activity
fun <T : AppCompatActivity> Context.toActivity(): T {
    return this as T
}
