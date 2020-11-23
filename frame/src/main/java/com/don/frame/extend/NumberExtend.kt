package com.don.frame.extend

import android.content.res.Resources
import com.don.frame.util.NumberUtil

fun Int.toDip(): Int {
    return (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}

fun Long.toDip(): Int {
    return (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}

fun Float.toDip(): Int {
    return (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}

fun Double.toDip(): Int {
    return (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}

fun Int.toSp(): Int {
    return (this / Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt()
}

fun Long.toSp(): Int {
    return (this / Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt()
}

fun Float.toSp(): Int {
    return (this / Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt()
}

fun Double.toSp(): Int {
    return (this / Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt()
}


fun Int?.isNullOrZero(): Boolean {
    return NumberUtil.isNullOrZero(this)
}

fun Long?.isNullOrZero(): Boolean {
    return NumberUtil.isNullOrZero(this)
}

fun Float?.isNullOrZero(): Boolean {
    return NumberUtil.isNullOrZero(this)
}

fun Double?.isNullOrZero(): Boolean {
    return NumberUtil.isNullOrZero(this)
}

fun Int?.constrain(low: Int, high: Int): Int? {
    return NumberUtil.constrain(this, low, high)
}

fun Long?.constrain(low: Long, high: Long): Long? {
    return NumberUtil.constrain(this, low, high)
}

fun Float?.constrain(low: Float, high: Float): Float? {
    return NumberUtil.constrain(this, low, high)
}

fun Double?.constrain(low: Double, high: Double): Double? {
    return NumberUtil.constrain(this, low, high)
}
