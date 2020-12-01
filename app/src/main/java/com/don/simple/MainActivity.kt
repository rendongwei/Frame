package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.core.base.adapter.ListenerAdapter
import com.don.frame.extend.addItemDecoration
import com.don.frame.extend.initLinearLayoutManager
import com.don.frame.extend.toDip
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.util.concurrent.CountDownLatch

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {

    }

    override fun init() {

        var c = CountDownLatch(2)

        Thread{
            Thread.sleep(10000)
            println(1)
            c.countDown()

            Thread.sleep(10000)
            println(2)
            c.countDown()
        }.start()

        c.await()

        mLvDisplay.initLinearLayoutManager().addItemDecoration(20.toDip(), 20.toDip(), 20.toDip(), 20.toDip()).adapter =
            ListenerAdapter(
                mContext,
                R.layout.fragment_main,
                mutableListOf("hahaha", "啊实打实的撒的按时撒的阿萨德啊打")
            ) { view, position, t ->
                with(view) {
                    textview.text = t
                }
            }
    }
}
