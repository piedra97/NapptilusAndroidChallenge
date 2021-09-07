package com.example.napptilusandroidchallenge.base

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import com.example.napptilusandroidchallenge.extensions.inflate

abstract class BaseRecyclerViewViewHolder<T>(
    parent: ViewGroup,
    @LayoutRes layoutResId: Int,
    itemView: View? = null,
) : RecyclerView.ViewHolder(itemView ?: parent.inflate(layoutResId)), LayoutContainer {

    override val containerView: View?
        get() = itemView

    abstract fun update(item: T)
}

