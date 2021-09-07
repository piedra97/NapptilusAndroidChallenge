package com.example.napptilusandroidchallenge.oompaloompalist

import android.view.ViewGroup
import com.example.napptilusandroidchallenge.R
import com.example.napptilusandroidchallenge.base.BaseRecyclerViewViewHolder
import com.example.napptilusandroidchallenge.databinding.OompaloompaItemViewListBinding
import com.example.napptilusandroidchallenge.extensions.url
import com.example.napptilusandroidchallenge.model.uimodels.OompaLoompaUIModel

class OompaLoompasViewHolder(
    parent: ViewGroup,
    private val binding: OompaloompaItemViewListBinding
) : BaseRecyclerViewViewHolder<OompaLoompaUIModel>(
    parent,
    R.layout.oompaloompa_item_view_list,
    binding.root
) {
    override fun update(item: OompaLoompaUIModel) {
        binding.apply {
            oompaloompaImage.url(item.image)
            oompaloompaName.text = item.name
            oompaloompaLastName.text = item.lastName
            oompaloompaProfession.text = item.profession
        }
    }
}