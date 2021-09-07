package com.example.napptilusandroidchallenge.oompaloompalist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.napptilusandroidchallenge.base.BaseRecyclerViewAdapter
import com.example.napptilusandroidchallenge.databinding.OompaloompaItemViewListBinding
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.model.uimodels.OompaLoompaUIModel

class OompaLoompaAdapter(
    private val onOompaLoompaClickedListener: (OompaLoompaUIModel) -> Unit
) : BaseRecyclerViewAdapter<OompaLoompaUIModel, OompaLoompasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OompaLoompasViewHolder =
        OompaLoompasViewHolder(
            parent,
            OompaloompaItemViewListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: OompaLoompasViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            onOompaLoompaClickedListener(getItem(position))
        }
    }

}

class OompaLoompaDiffCallback : DiffUtil.ItemCallback<OompaLoompa>() {
    override fun areItemsTheSame(oldItem: OompaLoompa, newItem: OompaLoompa): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: OompaLoompa, newItem: OompaLoompa): Boolean {
        return oldItem == newItem
    }

}
