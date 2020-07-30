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
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

// 获取显示指标
fun Context.getDisplayMetrics(): DisplayMetrics = resources.displayMetrics

// 获取屏幕宽度
fun Context.getScreenWidth(): Int = getDisplayMetrics().widthPixels

// 获取屏幕高度
fun Context.getScreenHeight(): Int = getDisplayMetrics().heightPixels

// 获取屏幕密度
fun Context.getScreenDensity(): Float = getDisplayMetrics().density

// 获取屏幕密度Dpi
fun Context.getScreenDensityDpi(): Int = getDisplayMetrics().densityDpi

// 获取屏幕尺度密度
fun Context.getScreenScaleDensity(): Float = getDisplayMetrics().scaledDensity

// dip转px
fun Context.dip2px(value: Float): Int = (value * getScreenDensity() + 0.5f).toInt()

// px转dip
fun Context.px2dip(value: Float): Int = (value / getScreenDensity() + 0.5f).toInt()

// sp转px
fun Context.sp2px(value: Float): Int = (value * getScreenScaleDensity() + 0.5f).toInt()

// px转sp
fun Context.px2sp(value: Float): Int = (value / getScreenScaleDensity() + 0.5f).toInt()

// 获取color
fun Context.color(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)

// 获取color
fun Context.color(color: String): Int = Color.parseColor(color)

// 获取drawable
fun Context.drawable(@DrawableRes id: Int): Drawable? = getDrawable(id)

// 获取string
fun Context.string(@StringRes id: Int) = getString(id)

// 获取layout
fun Context.layout(@LayoutRes id: Int): View = layout(id, null, false)

// 获取layout
fun Context.layout(@LayoutRes id: Int, parent: ViewGroup?, attachToRoot: Boolean): View =
    LayoutInflater.from(this).inflate(id, parent, attachToRoot)

// context转activity
fun <T : AppCompatActivity> Context.toActivity(): T {
    return this as T
}
