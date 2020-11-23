package com.don.frame.util

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import com.don.frame.extend.constrain


object ColorUtil {

    fun isLightColor(@ColorRes color: Int): Boolean {
        val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        if (darkness < 0.5) {
            return true
        }
        return false
    }

    fun setColorAlpha(@ColorInt color: Int, alpha: Float, override: Boolean = true): Int {
        val origin = if (override) 0xff else color shr 24 and 0xff
        return color and 0x00ffffff or ((alpha * origin) as Int shl 24)
    }

    fun computeColor(@ColorInt fromColor: Int, @ColorInt toColor: Int, fraction: Float): Int {
        var fraction = fraction.constrain(0.0f, 1.0f)!!

        var fromColorAlpha = Color.alpha(fromColor)
        var toColorAlpha = Color.alpha(toColor)
        var resultAlpha = (toColorAlpha - fromColorAlpha).times(fraction).toInt() + fromColorAlpha


        var fromColorRed = Color.red(fromColor)
        var toColorRed = Color.red(toColor)
        var resultRed = (toColorRed - fromColorRed).times(fraction).toInt() + fromColorRed

        var fromColorGreen = Color.green(fromColor)
        var toColorGreen = Color.green(toColor)
        var resultGreen = (toColorGreen - fromColorGreen).times(fraction).toInt() + fromColorGreen

        var fromColorBlue = Color.blue(fromColor)
        var toColorBlue = Color.blue(toColor)
        var resultBlue = (toColorBlue - fromColorBlue).times(fraction).toInt() + fromColorBlue

        return Color.argb(resultAlpha, resultRed, resultGreen, resultBlue)
    }

    fun colorToString(@ColorInt color: Int): String {
        return String.format("#%08X", color)
    }
}