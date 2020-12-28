package com.don.simple

import android.content.Context
import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.core.base.adapter.ListenerAdapter
import com.don.frame.core.base.viewmodel.BaseViewModel
import com.don.frame.extend.addItemDecoration
import com.don.frame.extend.initLinearLayoutManager
import com.don.frame.extend.showToast
import com.don.frame.extend.toDip
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
        m.setOnClickListener {
        }
    }

    override fun init() {
//        m.setRadiusAndShadow(8.toDip(), ILayout.HIDE_RADIUS_SIDE_NONE, 20, color("#Ff00fF"), 1.0f)

        mLvDisplay.initLinearLayoutManager()
            .addItemDecoration(20.toDip(), 20.toDip(), 20.toDip(), 20.toDip()).adapter =
            ListenerAdapter(
                mContext,
                R.layout.fragment_main,
                mutableListOf("hahaha", "啊实打实的撒的按时撒的阿萨德啊打")
            ) { view, position, t ->
                with(view) {
                    textview.text = t
                }
            }
        createViewModel(ViewM::class.java).login(mContext)
    }
}

class ViewM : BaseViewModel() {

    fun login(context: Context) {
        launch {
            var a = async {
                delay(20000)
                "哈哈"
            }
            var b = async {
                delay(10000)
                "你好"
            }
            withContext(Dispatchers.Main) {
                context.showToast(a.await() + b.await())
            }
        }
    }
}
