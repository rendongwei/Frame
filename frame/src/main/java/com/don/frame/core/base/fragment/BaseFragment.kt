package com.don.frame.core.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.don.frame.extend.layout
import com.don.frame.extend.toActivity
import com.don.frame.util.LogUtil

abstract class BaseFragment : Fragment() {

    protected lateinit var mApplicationContext: Context
    protected lateinit var mActivity: AppCompatActivity
    protected lateinit var mContext: Context
    protected var mContentView: View? = null

    companion object {
        val TAG = "Fragment"
    }

    @LayoutRes
    abstract fun getContentView(): Int

    abstract fun initListener()

    abstract fun init()

    open fun getCustomContentView(): View? {
        return null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.log(TAG, "onAttach: " + javaClass.canonicalName)
        mApplicationContext = context.applicationContext
        mContext = context!!
        mActivity = context.toActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.log(TAG, "onCreate: " + javaClass.canonicalName)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtil.log(TAG, "onCreateView: " + javaClass.canonicalName)
        mContentView = getCustomContentView() ?: layout(getContentView(), container, false)
        return mContentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogUtil.log(TAG, "onActivityCreated: " + javaClass.canonicalName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.log(TAG, "onViewCreated: " + javaClass.canonicalName)
        initListener()
        init()
    }

    override fun onStart() {
        super.onStart()
        LogUtil.log(TAG, "onStart: " + javaClass.canonicalName)
    }

    override fun onResume() {
        super.onResume()
        LogUtil.log(TAG, "onResume: " + javaClass.canonicalName)
    }

    override fun onPause() {
        super.onPause()
        LogUtil.log(TAG, "onPause: " + javaClass.canonicalName)
    }

    override fun onStop() {
        super.onStop()
        LogUtil.log(TAG, "onStop: " + javaClass.canonicalName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtil.log(TAG, "onDestroyView: " + javaClass.canonicalName)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.log(TAG, "onDestroy: " + javaClass.canonicalName)
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.log(TAG, "onDetach: " + javaClass.canonicalName)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtil.log(TAG, "onSaveInstanceState: " + javaClass.canonicalName)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            LogUtil.log(TAG, "onHiddenChanged  hidden: " + javaClass.canonicalName)
        } else {
            LogUtil.log(TAG, "onHiddenChanged  show: " + javaClass.canonicalName)
        }
    }
}