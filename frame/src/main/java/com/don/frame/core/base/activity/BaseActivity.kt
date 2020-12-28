package com.don.frame.core.base.activity

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.don.frame.core.base.viewmodel.BaseViewModel
import com.don.frame.extend.layout
import com.don.frame.manager.ActivityManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

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

    open fun noChangeScreenOrientation(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityManager.getInstance().addActivity(this)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        mSaveInstanceState = savedInstanceState

        if (!noChangeScreenOrientation()) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.navigationBarColor = Color.WHITE

        setContentView(mContentView)

        initListener()
        init()
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }

    protected fun <T : BaseViewModel> createViewModel(cls: Class<T>): T {
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(cls)
        lifecycle.addObserver(viewModel)
        return viewModel
    }
}