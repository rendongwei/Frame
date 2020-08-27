package com.don.frame.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.view.View

class LayoutHelper : ILayout {

    private var mContext: Context? = null

    private var mWidthLimit = 0
    private var mHeightLimit = 0
    private var mWidthMini = 0
    private var mHeightMini = 0

    constructor(context: Context?, owner: View) : this(context, null, owner)

    constructor(context: Context?, attrs: AttributeSet?, owner: View) : this(context, null, 0, owner)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, owner: View) {
        mContext = context
    }

    override fun setWidthLimit(widthLimit: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setHeightLimit(heightLimit: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOutlineExcludePadding(outlineExcludePadding: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShadowElevation(elevation: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShadowElevation(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShadowAlpha(shadowAlpha: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShadowAlpha(): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShadowColor(shadowColor: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShadowColor(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRadius(radius: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRadius(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOutlineInset(left: Int, top: Int, right: Int, bottom: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShowBorderOnlyBeforeL(showBorderOnlyBeforeL: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setHideRadiusSide(hideRadiusSide: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHideRadiusSide(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRadiusAndShadow(radius: Int, shadowElevation: Int, shadowAlpha: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRadiusAndShadow(radius: Int, hideRadiusSide: Int, shadowElevation: Int, shadowAlpha: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRadiusAndShadow(
        radius: Int,
        hideRadiusSide: Int,
        shadowElevation: Int,
        shadowColor: Int,
        shadowAlpha: Float
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBorderColor(borderColor: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBorderWidth(borderWidth: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTopDivider(topInsetLeft: Int, topInsetRight: Int, topDividerHeight: Int, topDividerColor: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateBottomDivider(
        bottomInsetLeft: Int,
        bottomInsetRight: Int,
        bottomDividerHeight: Int,
        bottomDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateLeftDivider(
        leftInsetTop: Int,
        leftInsetBottom: Int,
        leftDividerWidth: Int,
        leftDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRightDivider(
        rightInsetTop: Int,
        rightInsetBottom: Int,
        rightDividerWidth: Int,
        rightDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onlyShowTopDivider(
        topInsetLeft: Int,
        topInsetRight: Int,
        topDividerHeight: Int,
        topDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onlyShowBottomDivider(
        bottomInsetLeft: Int,
        bottomInsetRight: Int,
        bottomDividerHeight: Int,
        bottomDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onlyShowLeftDivider(
        leftInsetTop: Int,
        leftInsetBottom: Int,
        leftDividerWidth: Int,
        leftDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onlyShowRightDivider(
        rightInsetTop: Int,
        rightInsetBottom: Int,
        rightDividerWidth: Int,
        rightDividerColor: Int
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTopDividerAlpha(dividerAlpha: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBottomDividerAlpha(dividerAlpha: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLeftDividerAlpha(dividerAlpha: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRightDividerAlpha(dividerAlpha: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOuterNormalColor(color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateLeftSeparatorColor(color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRightSeparatorColor(color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTopSeparatorColor(color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateBottomSeparatorColor(color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasTopSeparator(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasRightSeparator(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasLeftSeparator(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasBottomSeparator(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasBorder(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}