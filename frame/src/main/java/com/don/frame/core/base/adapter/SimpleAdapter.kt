package com.don.frame.core.base.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.don.frame.extend.layout

abstract class SimpleAdapter<T> constructor(context: Context, list: MutableList<T>?) : BaseAdapter<T>(context, list) {

    @LayoutRes
    abstract fun getContentView(): Int

    abstract fun bindView(view: View, position: Int, t: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(mContext.layout(getContentView(), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.apply {
            bindView(holder.itemView, position, this)
        }
    }
}