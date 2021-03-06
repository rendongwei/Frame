package com.don.frame.widget.interfaces

import androidx.annotation.ColorInt

interface IShape {

    // 设置默认左上圆角
    fun setNormalLeftTopRadius(radius: Int)

    // 设置默认右上圆角
    fun setNormalRightTopRadius(radius: Int)

    // 设置默认左下圆角
    fun setNormalLeftBottomRadius(radius: Int)

    // 设置默认右下圆角
    fun setNormalRightBottomRadius(radius: Int)

    // 设置默认圆角
    fun setNormalRadius(radius: Int)

    // 设置默认左内距
    fun setNormalLeftPadding(padding: Int)

    // 设置默认上内距
    fun setNormalTopPadding(padding: Int)

    // 设置默认右内距
    fun setNormalRightPadding(padding: Int)

    // 设置默认下内距
    fun setNormalBottomPadding(padding: Int)

    // 设置默认内距
    fun setNormalPadding(padding: Int)

    // 设置默认背景色
    fun setNormalColor(@ColorInt color: Int)

    // 设置默认描线颜色
    fun setNormalStrokeColor(@ColorInt color: Int)

    // 设置默认描线宽度
    fun setNormalStrokeWidth(strokeWidth: Int)

    // 设置默认虚线宽度
    fun setNormalDashWidth(dashWidth: Int)

    // 设置默认虚线间距
    fun setNormalDashGap(dashGap: Int)

    // 设置按下左上圆角
    fun setPressedLeftTopRadius(radius: Int)

    // 设置按下右上圆角
    fun setPressedRightTopRadius(radius: Int)

    // 设置按下左下圆角
    fun setPressedLeftBottomRadius(radius: Int)

    // 设置按下右下圆角
    fun setPressedRightBottomRadius(radius: Int)

    // 设置按下圆角
    fun setPressedRadius(radius: Int)

    // 设置按下左内距
    fun setPressedLeftPadding(padding: Int)

    // 设置按下上内距
    fun setPressedTopPadding(padding: Int)

    // 设置按下右内距
    fun setPressedRightPadding(padding: Int)

    // 设置按下下内距
    fun setPressedBottomPadding(padding: Int)

    // 设置按下内距
    fun setPressedPadding(padding: Int)

    // 设置按下背景色
    fun setPressedColor(@ColorInt color: Int)

    // 设置按下描线颜色
    fun setPressedStrokeColor(@ColorInt color: Int)

    // 设置按下描线宽度
    fun setPressedStrokeWidth(strokeWidth: Int)

    // 设置按下虚线宽度
    fun setPressedDashWidth(dashWidth: Int)

    // 设置按下虚线间距
    fun setPressedDashGap(dashGap: Int)

    // 设置shape
    fun setShape()
}