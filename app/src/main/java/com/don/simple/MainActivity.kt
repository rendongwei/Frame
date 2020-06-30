package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.util.DeviceUtil

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
    }

    override fun init() {
        var fragment = MainFragment()
        var b = supportFragmentManager.beginTransaction()
        b.add(R.id.mLayoutContainer, fragment)
        b.show(fragment)
        b.commitAllowingStateLoss()
        DeviceUtil.isMIUI()
    }
}
