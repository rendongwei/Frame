package com.don.frame.core.base.activity

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected val mApplicationContext by lazy { applicationContext }
    protected val mActivity: AppCompatActivity by lazy { this }
    protected val mContext: Context by lazy { this }
    protected var mSaveInstanceState: Bundle? = null

    @LayoutRes
    abstract fun getContentView(): Int

    abstract fun initListener()

    abstract fun init()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}