package com.don.simple

import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.extend.color
import com.don.frame.extend.dip2px
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
        mLayoutContainer.setOnClickListener {

        }
    }

    override fun init() {
        mLayoutContainer.setNormalRadius(dip2px(20.0f))
        mLayoutContainer.setNormalColor(color("#FF0000"))

        mLayoutContainer.setPressedRadius(dip2px(30.0f))
        mLayoutContainer.setPressedColor(color("#F69420"))

        mLayoutContainer.setShape()
//        mLayoutContainer.setRadiusAndShadow(-2, ILayout.HIDE_RADIUS_SIDE_NONE, dip2px(10.0f), color("#FF0000"), 1.0f)
    }
}
