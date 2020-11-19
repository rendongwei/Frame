package com.don.frame.core.base.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.don.frame.extend.layout

class ListenerAdapter<T> constructor(
    context: Context,
    @LayoutRes
    var mContentView: Int,
    list: MutableList<T>?,
    var mListener: ((view: View, position: Int, t: T) -> Unit)
) :
    BaseAdapter<T>(context, list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(mContext.layout(mContentView, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.apply {
            mListener.invoke(holder.itemView, position, this)
        }
    }
}