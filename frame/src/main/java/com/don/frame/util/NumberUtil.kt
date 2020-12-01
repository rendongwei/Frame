package com.don.frame.util

import java.math.BigDecimal
import java.text.DecimalFormat

object NumberUtil {

    // 是否为null或者0
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

    // 显示范围
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

    // Pattern格式化
    fun format(any: Any, pattern: String? = null): String {
        var df = DecimalFormat()
        pattern?.apply {
            df.applyPattern(this)
        }
        return df.format(any)
    }

    // 保留小数格式化
    fun formatDecimal(value: Float, num: Int): String {
        var num = constrain(num, 0, num)
        return String.format("%.${num}f", value)
    }

    // 保留小数四舍五入格式化
    fun formatDecimalRoundHalfUp(value: Double, num: Int): Double {
        var num = constrain(num, 0, num)!!
        return BigDecimal(value).setScale(num, BigDecimal.ROUND_HALF_UP).toDouble()
    }
}