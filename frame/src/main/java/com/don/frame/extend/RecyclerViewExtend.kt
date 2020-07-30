package com.don.frame.extend

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.setNestedScrollingEnabled(): RecyclerView {
    return apply {
        isNestedScrollingEnabled = false
    }
}

fun RecyclerView.removeDefaultAnimator(): RecyclerView {
    return apply {
        //        if (itemAnimator is SimpleItemAnimator) {
//            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
//        }
        itemAnimator = null
    }
}

fun RecyclerView.initLinearLayoutManager(
    orientation: Int = RecyclerView.VERTICAL,
    itemDecoration: DividerItemDecoration? = null
): RecyclerView {
    return apply {
        itemDecoration?.let {
            addItemDecoration(itemDecoration)
        }
        var manager = MyLinearLayoutManager(context)
        manager.orientation = orientation
        manager.isSmoothScrollbarEnabled = true
        layoutManager = manager
    }
}

fun RecyclerView.initGridLayoutManager(
    spanCount: Int = 1,
    spanSizeLookup: GridLayoutManager.SpanSizeLookup? = null,
    itemDecoration: DividerItemDecoration? = null
): RecyclerView {
    return apply {
        itemDecoration?.let {
            addItemDecoration(itemDecoration)
        }
        var manager = GridLayoutManager(context, spanCount)
        manager.isSmoothScrollbarEnabled = true
        spanSizeLookup?.let {
            manager.spanSizeLookup = spanSizeLookup
        }
        layoutManager = manager
    }
}

class DividerItemDecoration constructor(@NonNull var mListener: ((position: Int) -> Rect)) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        var position = (view?.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        var rect = mListener.invoke(position)
        outRect?.set(rect)
    }
}

class MyLinearLayoutManager(context: Context) : LinearLayoutManager(context) {
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        try {
            super.onLayoutChildren(recycler, state)
        } catch (e: Exception) {
        }
    }
}