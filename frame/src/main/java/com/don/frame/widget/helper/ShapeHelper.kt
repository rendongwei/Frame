package com.don.frame.widget.helper

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import com.don.frame.widget.interfaces.IShape
import java.lang.ref.WeakReference

class ShapeHelper(owner: View) : IShape {

    private var mOwner: WeakReference<View>? = null

    private var mNormalLeftTopRadius: Int = 0
    private var mNormalRightTopRadius: Int = 0
    private var mNormalLeftBottomRadius: Int = 0
    private var mNormalRightBottomRadius: Int = 0
    private var mNormalRadius: Int = 0
    private var mNormalLeftPadding: Int = 0
    private var mNormalTopPadding: Int = 0
    private var mNormalRightPadding: Int = 0
    private var mNormalBottomPadding: Int = 0
    private var mNormalPadding: Int = 0
    private var mNormalColor: Int = 0
    private var mNormalStrokeColor: Int = 0
    private var mNormalStrokeWidth: Int = 0
    private var mNormalDashWidth: Int = 0
    private var mNormalDashGap: Int = 0

    private var mPressedLeftTopRadius: Int = 0
    private var mPressedRightTopRadius: Int = 0
    private var mPressedLeftBottomRadius: Int = 0
    private var mPressedRightBottomRadius: Int = 0
    private var mPressedRadius: Int = 0
    private var mPressedLeftPadding: Int = 0
    private var mPressedTopPadding: Int = 0
    private var mPressedRightPadding: Int = 0
    private var mPressedBottomPadding: Int = 0
    private var mPressedPadding: Int = 0
    private var mPressedColor: Int = 0
    private var mPressedStrokeColor: Int = 0
    private var mPressedStrokeWidth: Int = 0
    private var mPressedDashWidth: Int = 0
    private var mPressedDashGap: Int = 0

    init {
        mOwner = WeakReference(owner)
    }

    override fun setNormalLeftTopRadius(radius: Int) {
        mNormalLeftTopRadius = radius
    }

    override fun setNormalRightTopRadius(radius: Int) {
        mNormalRightTopRadius = radius
    }

    override fun setNormalLeftBottomRadius(radius: Int) {
        mNormalLeftBottomRadius = radius
    }

    override fun setNormalRightBottomRadius(radius: Int) {
        mNormalRightBottomRadius = radius
    }

    override fun setNormalRadius(radius: Int) {
        mNormalRadius = radius
    }

    override fun setNormalLeftPadding(padding: Int) {
        mNormalLeftPadding = padding
    }

    override fun setNormalTopPadding(padding: Int) {
        mNormalTopPadding = padding
    }

    override fun setNormalRightPadding(padding: Int) {
        mNormalRightPadding = padding
    }

    override fun setNormalBottomPadding(padding: Int) {
        mNormalBottomPadding = padding
    }

    override fun setNormalPadding(padding: Int) {
        mNormalPadding = padding
    }

    override fun setNormalColor(@ColorInt color: Int) {
        mNormalColor = color
    }

    override fun setNormalStrokeColor(@ColorInt color: Int) {
        mNormalStrokeColor = color
    }

    override fun setNormalStrokeWidth(strokeWidth: Int) {
        mNormalStrokeWidth = strokeWidth
    }

    override fun setNormalDashWidth(dashWidth: Int) {
        mNormalDashWidth = dashWidth
    }

    override fun setNormalDashGap(dashGap: Int) {
        mNormalDashGap = dashGap
    }

    override fun setPressedLeftTopRadius(radius: Int) {
        mPressedLeftTopRadius = radius
    }

    override fun setPressedRightTopRadius(radius: Int) {
        mPressedRightTopRadius = radius
    }

    override fun setPressedLeftBottomRadius(radius: Int) {
        mPressedLeftBottomRadius = radius
    }

    override fun setPressedRightBottomRadius(radius: Int) {
        mPressedRightBottomRadius = radius
    }

    override fun setPressedRadius(radius: Int) {
        mPressedRadius = radius
    }

    override fun setPressedLeftPadding(padding: Int) {
        mPressedLeftPadding = padding
    }

    override fun setPressedTopPadding(padding: Int) {
        mPressedTopPadding = padding
    }

    override fun setPressedRightPadding(padding: Int) {
        mPressedRightPadding = padding
    }

    override fun setPressedBottomPadding(padding: Int) {
        mPressedBottomPadding = padding
    }

    override fun setPressedPadding(padding: Int) {
        mPressedPadding = padding
    }

    override fun setPressedColor(@ColorInt color: Int) {
        mPressedColor = color
    }

    override fun setPressedStrokeColor(@ColorInt color: Int) {
        mPressedStrokeColor = color
    }

    override fun setPressedStrokeWidth(strokeWidth: Int) {
        mPressedStrokeWidth = strokeWidth
    }

    override fun setPressedDashWidth(dashWidth: Int) {
        mPressedDashWidth = dashWidth
    }

    override fun setPressedDashGap(dashGap: Int) {
        mPressedDashGap = dashGap
    }


    override fun setShape() {
        mOwner?.get()?.apply {
            var drawable = StateListDrawable()
            var pressedDrawable = getShape(
                mPressedLeftTopRadius,
                mPressedRightTopRadius,
                mPressedLeftBottomRadius,
                mPressedRightBottomRadius,
                mPressedRadius,
                mPressedLeftPadding,
                mPressedTopPadding,
                mPressedRightPadding,
                mPressedBottomPadding,
                mPressedPadding,
                mPressedColor,
                mPressedStrokeColor,
                mPressedStrokeWidth,
                mPressedDashWidth,
                mPressedDashGap
            )
            pressedDrawable?.apply {
                drawable.addState(intArrayOf(android.R.attr.state_pressed), this)
            }

            var normalDrawable = getShape(
                mNormalLeftTopRadius,
                mNormalRightTopRadius,
                mNormalLeftBottomRadius,
                mNormalRightBottomRadius,
                mNormalRadius,
                mNormalLeftPadding,
                mNormalTopPadding,
                mNormalRightPadding,
                mNormalBottomPadding,
                mNormalPadding,
                mNormalColor,
                mNormalStrokeColor,
                mNormalStrokeWidth,
                mNormalDashWidth,
                mNormalDashGap
            )
            if (normalDrawable == null) {
                drawable.addState(intArrayOf(), background)
            } else {
                drawable.addState(intArrayOf(), normalDrawable)
            }
            ViewHelper.setBackgroundKeepPadding(this, drawable)
        }
    }

    private fun hasShape(
        leftTopRadius: Int,
        rightTopRadius: Int,
        leftBottomRadius: Int,
        rightBottomRadius: Int,
        radius: Int,
        leftPadding: Int,
        topPadding: Int,
        rightPadding: Int,
        bottomPadding: Int,
        padding: Int,
        @ColorInt color: Int,
        @ColorInt strokeColor: Int,
        strokeWidth: Int,
        dashWidth: Int,
        dashGap: Int
    ): Boolean {
        if (leftTopRadius == 0 && rightTopRadius == 0 && leftBottomRadius == 0 && rightBottomRadius == 0
            && radius == 0 && leftPadding == 0 && topPadding == 0 && rightPadding == 0 && bottomPadding == 0
            && padding == 0 && color == 0 && strokeColor == 0 && strokeWidth == 0 && dashWidth == 0
            && dashGap == 0
        ) {
            return false
        }
        return true
    }

    private fun getShape(
        leftTopRadius: Int,
        rightTopRadius: Int,
        leftBottomRadius: Int,
        rightBottomRadius: Int,
        radius: Int,
        leftPadding: Int,
        topPadding: Int,
        rightPadding: Int,
        bottomPadding: Int,
        padding: Int,
        @ColorInt color: Int,
        @ColorInt strokeColor: Int,
        strokeWidth: Int,
        dashWidth: Int,
        dashGap: Int
    ): Drawable? {
        if (!hasShape(
                leftTopRadius,
                rightTopRadius,
                leftBottomRadius,
                rightBottomRadius,
                radius,
                leftPadding,
                topPadding,
                rightPadding,
                bottomPadding,
                padding,
                color,
                strokeColor,
                strokeWidth,
                dashWidth,
                dashGap
            )
        ) {
            return null
        }
        var drawable = GradientDrawable()
        drawable.shape = GradientDrawable.RECTANGLE

        if (radius == 0) {
            drawable.cornerRadii = floatArrayOf(
                leftTopRadius.toFloat(),
                leftTopRadius.toFloat(),
                rightTopRadius.toFloat(),
                rightTopRadius.toFloat(),
                leftBottomRadius.toFloat(),
                leftBottomRadius.toFloat(),
                rightBottomRadius.toFloat(),
                rightBottomRadius.toFloat()
            )
        } else {
            drawable.cornerRadius = radius.toFloat()
        }
        if (padding == 0) {
            if (Build.VERSION.SDK_INT >= 29) {
                drawable.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
            } else {
                drawable.setBounds(leftPadding, topPadding, rightPadding, bottomPadding)
            }
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                drawable.setPadding(padding, padding, padding, padding)
            } else {
                drawable.setBounds(padding, padding, padding, padding)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable.color = ColorStateList.valueOf(color)
        } else {
            drawable.setColor(color)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable.setStroke(strokeWidth, ColorStateList.valueOf(strokeColor), dashWidth.toFloat(), dashGap.toFloat())
        } else {
            drawable.setStroke(strokeWidth, strokeColor, dashWidth.toFloat(), dashGap.toFloat())
        }
        return drawable
    }
}