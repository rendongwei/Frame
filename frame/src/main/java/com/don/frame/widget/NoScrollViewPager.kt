package com.don.frame.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

open class NoScrollViewPager : ViewPager {

    private var isScrollable = false

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (isScrollable) {
            return super.onInterceptTouchEvent(ev)
        }
        return false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (isScrollable) {
            super.onTouchEvent(ev)
        }
        return false
    }

    fun setScrollable(scrollable:Boolean){
        isScrollable = scrollable
    }
}