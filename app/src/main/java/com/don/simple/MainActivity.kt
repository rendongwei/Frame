package com.don.simple

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.core.base.adapter.ListenerAdapter
import com.don.frame.extend.addItemDecoration
import com.don.frame.extend.initLinearLayoutManager
import com.don.frame.extend.toDip
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

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

    protected fun <T : BaseViewModel> createViewModel(cls: Class<T>): T {
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(cls)
        lifecycle.addObserver(viewModel)
        return viewModel
    }
}

class ViewM : BaseViewModel() {

    fun login(context: Context) {

    }
}

