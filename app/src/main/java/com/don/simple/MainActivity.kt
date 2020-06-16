package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
    }

    override fun init() {

    }

    override fun setStatusBarColorFinish() {
        super.setStatusBarColorFinish()
        setStatusBarTransparent()
    }
}
