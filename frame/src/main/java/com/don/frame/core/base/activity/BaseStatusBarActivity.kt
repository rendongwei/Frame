package com.don.frame.core.base.activity

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.ColorRes
import com.don.frame.R
import com.don.frame.extend.color
import com.jaeger.library.StatusBarUtil

abstract class BaseStatusBarActivity : BaseActivity() {

    open fun getStatusBarColor(): Int {
        return R.color.white
    }

    open fun setStatusBarColorFinish() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        mContentView.fitsSystemWindows = true
        super.onCreate(savedInstanceState)
        var color = color(getStatusBarColor())
        StatusBarUtil.setColorNoTranslucent(mActivity, color)
        if (isLightColor(color)) {
            StatusBarUtil.setLightMode(mActivity)
        } else {
            StatusBarUtil.setDarkMode(mActivity)
        }
        setStatusBarColorFinish()
    }

    private fun isLightColor(@ColorRes color: Int): Boolean {
        val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        if (darkness < 0.5) {
            return true
        }
        return false
    }

    fun setStatusBarTransparent() {
        StatusBarUtil.setTransparent(mActivity)
    }
}