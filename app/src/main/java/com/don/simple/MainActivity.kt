package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
        mLayoutContainer.setOnClickListener {
        }
    }

    override fun init() {

    }
}
