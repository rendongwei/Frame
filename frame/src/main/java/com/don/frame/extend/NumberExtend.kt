package com.don.frame.extend

import android.content.res.Resources

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
