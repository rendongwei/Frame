package com.don.frame.core.base.adapter

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.don.frame.extend.toActivity

open abstract class BaseAdapter<T> constructor(protected var mContext: Context, private var mList: MutableList<T>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val mActivity by lazy {
        mContext.toActivity<AppCompatActivity>()
    }


    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    fun getItem(position: Int): T? {
        if (position < 0 || position > itemCount - 1) {
            return null
        }
        return mList?.getOrNull(position)
    }

    fun get(): MutableList<T>? {
        return mList
    }

    fun add(t: T) {
        add(-1, t)
    }

    fun add(index: Int, t: T) {
        addAll(index, mutableListOf(t))
    }

    fun addAll(t: MutableList<T>) {
        addAll(-1, t)
    }

    fun addAll(index: Int, t: MutableList<T>) {
        mList?.apply {
            var position = when {
                index < 0 || index > lastIndex -> lastIndex + 1
                else -> index
            }
            addAll(position, t)
            notifyItemInserted(position)
            if (itemCount - position > 0) {
                notifyItemRangeChanged(position, size - position)
            }
        }
    }

    fun remove(index: Int) {
        mList?.apply {
            if (isEmpty() || index < 0 || index > lastIndex) {
                return
            }
            removeAt(index)
            notifyItemRemoved(index)
            if (itemCount - index > 0) {
                notifyItemRangeChanged(index, size - index)
            }
        }
    }

    fun removeAll() {
        mList?.apply {
            clear()
            notifyDataSetChanged()
        }
    }

    fun change(index: Int) {
        notifyItemChanged(index)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
