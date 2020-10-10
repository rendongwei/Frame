package com.don.frame.widget.textview

import android.content.Context
import android.util.AttributeSet
import com.don.frame.widget.helper.ShapeHelper
import com.don.frame.widget.interfaces.IShape

class ShapeTextView : DTextView, IShape {

    private var mShapeHelper: ShapeHelper

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context!!,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        mShapeHelper = ShapeHelper(context, attrs, defStyleAttr, defStyleRes, this)
    }

    override fun setNormalLeftTopRadius(radius: Int) {
        mShapeHelper.setNormalLeftTopRadius(radius)
    }

    override fun setNormalRightTopRadius(radius: Int) {
        mShapeHelper.setNormalRightTopRadius(radius)
    }

    override fun setNormalLeftBottomRadius(radius: Int) {
        mShapeHelper.setNormalLeftBottomRadius(radius)
    }

    override fun setNormalRightBottomRadius(radius: Int) {
        mShapeHelper.setNormalRightBottomRadius(radius)
    }

    override fun setNormalRadius(radius: Int) {
        mShapeHelper.setNormalRadius(radius)
    }

    override fun setNormalLeftPadding(padding: Int) {
        mShapeHelper.setNormalLeftPadding(padding)
    }

    override fun setNormalTopPadding(padding: Int) {
        mShapeHelper.setNormalTopPadding(padding)
    }

    override fun setNormalRightPadding(padding: Int) {
        mShapeHelper.setNormalRightPadding(padding)
    }

    override fun setNormalBottomPadding(padding: Int) {
        mShapeHelper.setNormalBottomPadding(padding)
    }

    override fun setNormalPadding(padding: Int) {
        mShapeHelper.setNormalPadding(padding)
    }

    override fun setNormalColor(color: Int) {
        mShapeHelper.setNormalColor(color)
    }

    override fun setNormalStrokeColor(color: Int) {
        mShapeHelper.setNormalStrokeColor(color)
    }

    override fun setNormalStrokeWidth(strokeWidth: Int) {
        mShapeHelper.setNormalStrokeWidth(strokeWidth)
    }

    override fun setNormalDashWidth(dashWidth: Int) {
        mShapeHelper.setNormalDashWidth(dashWidth)
    }

    override fun setNormalDashGap(dashGap: Int) {
        mShapeHelper.setNormalDashGap(dashGap)
    }

    override fun setPressedLeftTopRadius(radius: Int) {
        mShapeHelper.setPressedLeftTopRadius(radius)
    }

    override fun setPressedRightTopRadius(radius: Int) {
        mShapeHelper.setPressedRightTopRadius(radius)
    }

    override fun setPressedLeftBottomRadius(radius: Int) {
        mShapeHelper.setPressedLeftBottomRadius(radius)
    }

    override fun setPressedRightBottomRadius(radius: Int) {
        mShapeHelper.setPressedRightBottomRadius(radius)
    }

    override fun setPressedRadius(radius: Int) {
        mShapeHelper.setPressedRadius(radius)
    }

    override fun setPressedLeftPadding(padding: Int) {
        mShapeHelper.setPressedLeftPadding(padding)
    }

    override fun setPressedTopPadding(padding: Int) {
        mShapeHelper.setPressedTopPadding(padding)
    }

    override fun setPressedRightPadding(padding: Int) {
        mShapeHelper.setPressedRightPadding(padding)
    }

    override fun setPressedBottomPadding(padding: Int) {
        mShapeHelper.setPressedBottomPadding(padding)
    }

    override fun setPressedPadding(padding: Int) {
        mShapeHelper.setPressedPadding(padding)
    }

    override fun setPressedColor(color: Int) {
        mShapeHelper.setPressedColor(color)
    }

    override fun setPressedStrokeColor(color: Int) {
        mShapeHelper.setPressedStrokeColor(color)
    }

    override fun setPressedStrokeWidth(strokeWidth: Int) {
        mShapeHelper.setPressedStrokeWidth(strokeWidth)
    }

    override fun setPressedDashWidth(dashWidth: Int) {
        mShapeHelper.setPressedDashWidth(dashWidth)
    }

    override fun setPressedDashGap(dashGap: Int) {
        mShapeHelper.setPressedDashGap(dashGap)
    }

    override fun setShape() {
        mShapeHelper.setShape()
    }
}