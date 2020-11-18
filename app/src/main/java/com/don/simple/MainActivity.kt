package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.extend.addItemDecoration
import com.don.frame.extend.initLinearLayoutManager
import com.don.frame.extend.toDip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
    }

    override fun init() {
        mLvDisplay.initLinearLayoutManager().addItemDecoration(20.toDip(), 20.toDip(), 20.toDip(), 20.toDip()).adapter =
            A(mContext, mutableListOf("hahaha", "啊实打实的撒的按时撒的阿萨德啊打"))
    }
}
