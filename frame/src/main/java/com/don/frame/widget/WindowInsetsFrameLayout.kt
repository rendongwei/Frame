package com.don.frame.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import android.widget.FrameLayout

class WindowInsetsFrameLayout : FrameLayout {

    init {
        setOnHierarchyChangeListener(object : OnHierarchyChangeListener {
            override fun onChildViewRemoved(p0: View?, p1: View?) {
            }

            override fun onChildViewAdded(p0: View?, p1: View?) {
                requestApplyInsets()
            }
        })
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onApplyWindowInsets(insets: WindowInsets?): WindowInsets {
        var childCount = childCount
        for (index in 0 until childCount) {
            getChildAt(index).dispatchApplyWindowInsets(insets)
        }
        return insets!!
    }
}