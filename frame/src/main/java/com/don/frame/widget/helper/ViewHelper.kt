package com.don.frame.widget.helper

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.TouchDelegate
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

object ViewHelper {

    fun setBackgroundKeepPadding(view: View, drawable: Drawable?) {
        var padding = intArrayOf(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.background = drawable
        } else {
            view.setBackgroundDrawable(drawable)
        }
        view.setPadding(padding[0], padding[1], padding[2], padding[3])
    }

    fun setBackgroundKeepPadding(view: View, drawable: Int) {
        setBackgroundKeepPadding(view, ContextCompat.getDrawable(view.context, drawable))
    }

    fun setBackgroundColorKeepPadding(view: View, @ColorInt color: Int) {
        var padding = intArrayOf(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)
        view.setBackgroundColor(color)
        view.setPadding(padding[0], padding[1], padding[2], padding[3])
    }


    fun expendTouchArea(view: View, expendSize: Int) {
        view?.apply {
            val parent = (parent as View)
            parent.post {
                var rect = Rect()
                getHitRect(rect)
                rect.left -= expendSize
                rect.top -= expendSize
                rect.right += expendSize
                rect.bottom += expendSize
                parent.touchDelegate = TouchDelegate(rect, this)
            }
        }
    }
}