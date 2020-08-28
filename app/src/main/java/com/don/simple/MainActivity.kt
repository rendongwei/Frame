package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.extend.color
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {

    }

    override fun init() {
        mLayoutContainer.onlyShowTopDivider(20,20,2,color("#FF0124"))
    }
}
