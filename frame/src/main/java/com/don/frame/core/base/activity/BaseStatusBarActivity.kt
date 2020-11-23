package com.don.frame.core.base.activity

import android.os.Bundle
import com.don.frame.R
import com.don.frame.extend.color
import com.don.frame.util.ColorUtil
import com.jaeger.library.StatusBarUtil

abstract class BaseStatusBarActivity : BaseActivity() {

    open fun getStatusBarColor(): Int {
        return R.color.white
    }

    open fun isFitsSystemWindows(): Boolean {
        return true
    }

    open fun setStatusBarColorFinish() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        mContentView.fitsSystemWindows = isFitsSystemWindows()
        super.onCreate(savedInstanceState)
        var color = color(getStatusBarColor())
        StatusBarUtil.setColorNoTranslucent(mActivity, color)
        if (ColorUtil.isLightColor(color)) {
            StatusBarUtil.setLightMode(mActivity)
        } else {
            StatusBarUtil.setDarkMode(mActivity)
        }
        setStatusBarColorFinish()
    }

    fun setStatusBarTransparent() {
        StatusBarUtil.setTransparent(mActivity)
    }

    fun setLightMode() {
        StatusBarUtil.setLightMode(mActivity)
    }

    fun setDarkMode() {
        StatusBarUtil.setDarkMode(mActivity)
    }
}