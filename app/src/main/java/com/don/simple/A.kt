package com.don.simple

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.don.frame.core.base.adapter.BaseAdapter
import com.don.frame.extend.layout
import kotlinx.android.synthetic.main.fragment_main.view.*

class A(context: Context, list: MutableList<String>?) : BaseAdapter<String>(context, list) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(mContext.layout(R.layout.fragment_main, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder.itemView) {
            getItem(position)?.apply {
                textview.text = this
            }
        }
    }
}