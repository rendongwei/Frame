package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.extend.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseStatusBarActivity() {

    private var a: ((i: Int) -> Unit)? = null
    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
        mLayoutContainer.setOnClickListener {
            showToast("asdasdasd")
        }
    }

    override fun init() {
    }
}
