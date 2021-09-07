package com.example.napptilusandroidchallenge.base

import androidx.recyclerview.widget.RecyclerView.Adapter

abstract class BaseRecyclerViewAdapter<T, VH : BaseRecyclerViewViewHolder<T>> :
    Adapter<VH>() {

    private var items: List<T> = emptyList()
    private var onItemClicked: (T) -> Unit = {}
    private var isClickable: Boolean = true

    fun setItems(newItems: List<T>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun setIsClickable(isClickable: Boolean) {
        this.isClickable = isClickable
    }

    fun setOnItemClicked(onItemClicked: (T) -> Unit) {
        this.onItemClicked = onItemClicked
    }

    fun getItem(position: Int): T = items[position]

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.update(item)
        if (isClickable) holder.itemView.setOnClickListener { onItemClicked(item) }
    }
}