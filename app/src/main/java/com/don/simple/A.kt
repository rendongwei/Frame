package com.don.simple

import android.content.Context
import android.view.View
import com.don.frame.core.base.adapter.SimpleAdapter
import kotlinx.android.synthetic.main.fragment_main.view.*

class A(context: Context, list: MutableList<String>?) : SimpleAdapter<String>(context, list) {

    override fun getContentView(): Int {
        return R.layout.fragment_main
    }

    override fun bindView(view: View, position: Int, t: String) {
        with(view) {
            textview.text = t
        }
    }

}