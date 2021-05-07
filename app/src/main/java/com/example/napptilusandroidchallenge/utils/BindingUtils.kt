package com.example.napptilusandroidchallenge.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.example.napptilusandroidchallenge.R
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus
import com.example.napptilusandroidchallenge.oompaloompalist.OompaLoompaAdapter


@BindingAdapter("oompaLoompaImage")
fun ImageView.setOompaLoompaImage(item: OompaLoompa?) {
    item?.image.let {
        val imgUri =
                item?.image?.toUri()?.buildUpon()?.scheme("https")?.build()
        Glide.with(this.context)
                .load(imgUri)
                .apply(RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(this)
    }
}

@BindingAdapter("oompaLoompaName")
fun TextView.setOompaLoompaName(item: OompaLoompa?) {
    text = item?.firstName
}

@BindingAdapter("oompaLoompaLastName")
fun TextView.setOompaLoompaLastName(item: OompaLoompa?) {
    text = item?.lastName
}

@BindingAdapter("oompaLoompaProfession")
fun TextView.setOompaLoompaProfession(item: OompaLoompa?) {
    text = item?.profession
}

@BindingAdapter("oompaLoompaGender")
fun TextView.setOompaLoompaGender(item: OompaLoompa?) {
    text = item?.gender.toString()

}

@BindingAdapter("oompaLoompaEmail")
fun TextView.setOompaLoompaEmail(item: OompaLoompa?) {
    text = item?.email
}

@BindingAdapter("oompaLoompaCountry")
fun TextView.setOompaLoompaCountry(item: OompaLoompa?) {
    text = item?.country
}

@BindingAdapter("oompaLoompaAge")
fun TextView.setOompaLoompaAge(item: OompaLoompa?) {
    text = item?.age.toString()
}

@BindingAdapter("oompaLoompaHeight")
fun TextView.setOompaLoompaHeight(item: OompaLoompa?) {
    text = item?.height.toString()
}

@BindingAdapter("oompaLoompaFavoriteColor")
fun TextView.setOompaLoompaFavoriteColor(item: OompaLoompa?) {
    text = item?.favorite?.color
}

@BindingAdapter("oompaLoompaFavoriteFood")
fun TextView.setOompaLoompaFavoriteFood(item: OompaLoompa?) {
    text = item?.favorite?.food
}

@BindingAdapter("oompaLoompaStatus")
fun bindStatus(statusImageView: ImageView, status: OompaLoompaApiStatus?) {
    when (status) {
        OompaLoompaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        OompaLoompaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }

        OompaLoompaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("oompaLoompaListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<OompaLoompa>?) {
    val adapter = recyclerView.adapter as OompaLoompaAdapter
    adapter.submitList(data)
}
