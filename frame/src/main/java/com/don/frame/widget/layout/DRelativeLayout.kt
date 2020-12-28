package com.don.frame.widget.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.don.frame.widget.helper.LayoutHelper
import com.don.frame.widget.interfaces.ILayout

open class DRelativeLayout : RelativeLayout, ILayout {

    private var mLayoutHelper: LayoutHelper

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(
        context!!,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        mLayoutHelper = LayoutHelper(context, attrs, defStyleAttr, this)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasureSpec = mLayoutHelper.getMeasuredWidthSpec(widthMeasureSpec)
        val heightMeasureSpec = mLayoutHelper.getMeasuredHeightSpec(heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val minW = mLayoutHelper.handleMiniWidth(widthMeasureSpec, measuredWidth)
        val minH = mLayoutHelper.handleMiniHeight(heightMeasureSpec, measuredHeight)
        if (widthMeasureSpec !== minW || heightMeasureSpec !== minH) {
            super.onMeasure(minW, minH)
        }
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        mLayoutHelper.drawDividers(canvas!!, width, height)
        mLayoutHelper.dispatchRoundBorderDraw(canvas!!)
    }

    override fun setWidthLimit(widthLimit: Int): Boolean {
        return mLayoutHelper.setWidthLimit(widthLimit)
    }

    override fun setHeightLimit(heightLimit: Int): Boolean {
        return mLayoutHelper.setHeightLimit(heightLimit)
    }

    override fun setOutlineExcludePadding(outlineExcludePadding: Boolean) {
        mLayoutHelper.setOutlineExcludePadding(outlineExcludePadding)
    }

    override fun setShadowElevation(elevation: Int) {
        mLayoutHelper.setShadowElevation(elevation)
    }

    override fun getShadowElevation(): Int {
        return mLayoutHelper.getShadowElevation()
    }

    override fun setShadowAlpha(shadowAlpha: Float) {
        mLayoutHelper.setShadowAlpha(shadowAlpha)
    }

    override fun getShadowAlpha(): Float {
        return mLayoutHelper.getShadowAlpha()
    }

    override fun setShadowColor(shadowColor: Int) {
        mLayoutHelper.setShadowColor(shadowColor)
    }

    override fun getShadowColor(): Int {
        return mLayoutHelper.getShadowColor()
    }

    override fun setRadius(radius: Int) {
        mLayoutHelper.setRadius(radius)
    }

    override fun setRadius(radius: Int, hideRadiusSide: Int) {
        mLayoutHelper.setRadius(radius, hideRadiusSide)
    }

    override fun getRadius(): Int {
        return mLayoutHelper.getRadius()
    }

    override fun setOutlineInset(left: Int, top: Int, right: Int, bottom: Int) {
        mLayoutHelper.setOutlineInset(left, top, right, bottom)
    }

    override fun setShowBorderOnlyBeforeL(showBorderOnlyBeforeL: Boolean) {
        mLayoutHelper.setShowBorderOnlyBeforeL(showBorderOnlyBeforeL)
    }

    override fun setHideRadiusSide(hideRadiusSide: Int) {
        mLayoutHelper.setHideRadiusSide(hideRadiusSide)
    }

    override fun getHideRadiusSide(): Int {
        return mLayoutHelper.getHideRadiusSide()
    }

    override fun setRadiusAndShadow(radius: Int, shadowElevation: Int, shadowAlpha: Float) {
        mLayoutHelper.setRadiusAndShadow(radius, shadowElevation, shadowAlpha)
    }

    override fun setRadiusAndShadow(
        radius: Int,
        hideRadiusSide: Int,
        shadowElevation: Int,
        shadowAlpha: Float
    ) {
        mLayoutHelper.setRadiusAndShadow(radius, hideRadiusSide, shadowElevation, shadowAlpha)
    }

    override fun setRadiusAndShadow(
        radius: Int,
        hideRadiusSide: Int,
        shadowElevation: Int,
        shadowColor: Int,
        shadowAlpha: Float
    ) {
        mLayoutHelper.setRadiusAndShadow(
            radius,
            hideRadiusSide,
            shadowElevation,
            shadowColor,
            shadowAlpha
        )
    }

    override fun setBorderColor(borderColor: Int) {
        mLayoutHelper.setBorderColor(borderColor)
    }

    override fun setBorderWidth(borderWidth: Int) {
        mLayoutHelper.setBorderWidth(borderWidth)
    }

    override fun updateTopDivider(
        topInsetLeft: Int,
        topInsetRight: Int,
        topDividerHeight: Int,
        topDividerColor: Int
    ) {
        mLayoutHelper.updateTopDivider(
            topInsetLeft,
            topInsetRight,
            topDividerHeight,
            topDividerColor
        )
    }

    override fun updateBottomDivider(
        bottomInsetLeft: Int,
        bottomInsetRight: Int,
        bottomDividerHeight: Int,
        bottomDividerColor: Int
    ) {
        mLayoutHelper.updateBottomDivider(
            bottomInsetLeft,
            bottomInsetRight,
            bottomDividerHeight,
            bottomDividerColor
        )
    }

    override fun updateLeftDivider(
        leftInsetTop: Int,
        leftInsetBottom: Int,
        leftDividerWidth: Int,
        leftDividerColor: Int
    ) {
        mLayoutHelper.updateLeftDivider(
            leftInsetTop,
            leftInsetBottom,
            leftDividerWidth,
            leftDividerColor
        )
    }

    override fun updateRightDivider(
        rightInsetTop: Int,
        rightInsetBottom: Int,
        rightDividerWidth: Int,
        rightDividerColor: Int
    ) {
        mLayoutHelper.updateRightDivider(
            rightInsetTop,
            rightInsetBottom,
            rightDividerWidth,
            rightDividerColor
        )
    }

    override fun onlyShowTopDivider(
        topInsetLeft: Int,
        topInsetRight: Int,
        topDividerHeight: Int,
        topDividerColor: Int
    ) {
        mLayoutHelper.onlyShowTopDivider(
            topInsetLeft,
            topInsetRight,
            topDividerHeight,
            topDividerColor
        )
    }

    override fun onlyShowBottomDivider(
        bottomInsetLeft: Int,
        bottomInsetRight: Int,
        bottomDividerHeight: Int,
        bottomDividerColor: Int
    ) {
        mLayoutHelper.onlyShowBottomDivider(
            bottomInsetLeft,
            bottomInsetRight,
            bottomDividerHeight,
            bottomDividerColor
        )
    }

    override fun onlyShowLeftDivider(
        leftInsetTop: Int,
        leftInsetBottom: Int,
        leftDividerWidth: Int,
        leftDividerColor: Int
    ) {
        mLayoutHelper.onlyShowLeftDivider(
            leftInsetTop,
            leftInsetBottom,
            leftDividerWidth,
            leftDividerColor
        )
    }

    override fun onlyShowRightDivider(
        rightInsetTop: Int,
        rightInsetBottom: Int,
        rightDividerWidth: Int,
        rightDividerColor: Int
    ) {
        mLayoutHelper.onlyShowRightDivider(
            rightInsetTop,
            rightInsetBottom,
            rightDividerWidth,
            rightDividerColor
        )
    }

    override fun setTopDividerAlpha(dividerAlpha: Int) {
        mLayoutHelper.setTopDividerAlpha(dividerAlpha)
    }

    override fun setBottomDividerAlpha(dividerAlpha: Int) {
        mLayoutHelper.setBottomDividerAlpha(dividerAlpha)
    }

    override fun setLeftDividerAlpha(dividerAlpha: Int) {
        mLayoutHelper.setLeftDividerAlpha(dividerAlpha)
    }

    override fun setRightDividerAlpha(dividerAlpha: Int) {
        mLayoutHelper.setRightDividerAlpha(dividerAlpha)
    }

    override fun setOuterNormalColor(color: Int) {
        mLayoutHelper.setOuterNormalColor(color)
    }

    override fun updateLeftSeparatorColor(color: Int) {
        mLayoutHelper.updateLeftSeparatorColor(color)
    }

    override fun updateRightSeparatorColor(color: Int) {
        mLayoutHelper.updateRightSeparatorColor(color)
    }

    override fun updateTopSeparatorColor(color: Int) {
        mLayoutHelper.updateTopSeparatorColor(color)
    }

    override fun updateBottomSeparatorColor(color: Int) {
        mLayoutHelper.updateBottomSeparatorColor(color)
    }

    override fun hasTopSeparator(): Boolean {
        return mLayoutHelper.hasTopSeparator()
    }

    override fun hasRightSeparator(): Boolean {
        return mLayoutHelper.hasRightSeparator()
    }

    override fun hasLeftSeparator(): Boolean {
        return mLayoutHelper.hasLeftSeparator()
    }

    override fun hasBottomSeparator(): Boolean {
        return mLayoutHelper.hasBottomSeparator()
    }

    override fun hasBorder(): Boolean {
        return mLayoutHelper.hasBorder()
    }
}