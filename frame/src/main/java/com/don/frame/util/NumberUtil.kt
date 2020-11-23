package com.don.frame.util

import java.text.DecimalFormat

object NumberUtil {

    fun isNullOrZero(any: Any?): Boolean {
        any?.apply {
            return when (this) {
                is Int -> this == 0
                is Long -> this == 0L
                is Float -> this == 0F
                is Double -> this == 0.0
                else -> false
            }
        }
        return true
    }

    fun <T : Comparable<T>> constrain(original: T?, low: T, high: T): T? {
        original?.apply {
            return when {
                this < low -> low
                this > high -> high
                else -> this
            }
        }
        return original
    }

    fun format(any: Any, pattern: String? = null): String {
        var df = DecimalFormat()
        pattern?.apply {
            df.applyPattern(this)
        }
        return df.format(any)
    }
}