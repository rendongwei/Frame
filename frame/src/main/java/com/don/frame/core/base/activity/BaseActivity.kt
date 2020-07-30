package com.don.frame.core.base.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.don.frame.extend.layout
import com.don.frame.manager.ActivityManager

abstract class BaseActivity : AppCompatActivity() {

    protected val mApplicationContext by lazy { applicationContext }
    protected val mActivity: AppCompatActivity by lazy { this }
    protected val mContext: Context by lazy { this }
    protected var mSaveInstanceState: Bundle? = null
    protected val mContentView: View by lazy { getCustomContentView() ?: layout(getContentView()) }

    companion object {
        val TAG = "Activity"
    }

    @LayoutRes
    abstract fun getContentView(): Int

    abstract fun initListener()

    abstract fun init()

    open fun getCustomContentView(): View? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityManager.getInstance().addActivity(this)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        mSaveInstanceState = savedInstanceState
        setContentView(mContentView)

        initListener()
        init()
    }


}