package com.example.napptilusandroidchallenge.oompaloompalist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.databinding.OompaloompaItemViewListBinding

class OompaLoompaAdapter(val clickListener: OompaLoompaListener) : ListAdapter<OompaLoompa, OompaLoompaAdapter.ViewHolder>(OompaLoompaDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder private constructor(val binding: OompaloompaItemViewListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: OompaLoompa,
            clickListener: OompaLoompaListener
        ) {
            binding.oompaloompa = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = OompaloompaItemViewListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
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

class OompaLoompaListener(val clickListener: (oompaLoompaId: Long) -> Unit) {
    fun onClick(oompaLoompa: OompaLoompa) = clickListener(oompaLoompa.id)
}