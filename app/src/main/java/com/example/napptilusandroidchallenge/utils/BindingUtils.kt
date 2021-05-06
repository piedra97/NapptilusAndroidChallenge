package com.example.napptilusandroidchallenge.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.napptilusandroidchallenge.R
import com.example.napptilusandroidchallenge.model.OompaLoompa
import com.example.napptilusandroidchallenge.oompaloompalist.OompaLoompaApiStatus


@BindingAdapter("oompaLoompaImage")
fun ImageView.setOompaLoompaImage(item: OompaLoompa) {
    item.image.let {
        val imgUri =
                item.image.toUri().buildUpon().scheme("https").build()
        Glide.with(this.context)
                .load(imgUri)
                .apply(RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image))
                .into(this)
    }
}

@BindingAdapter("oompaLoompaName")
fun TextView.setOompaLoompaName(item: OompaLoompa) {
    text = item.firstName
}

@BindingAdapter("oompaLoompaLastName")
fun TextView.setOompaLoompaLastName(item: OompaLoompa) {
    text = item.lastName
}

@BindingAdapter("oompaLoompaProfession")
fun TextView.setOompaLoompaProfession(item: OompaLoompa) {
    text = item.profession
}

@BindingAdapter("oompaLoompaGender")
fun TextView.setOompaLoompaGender(item: OompaLoompa) {
    text = item.gender.toString()

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

        OompaLoompaApiStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_no_oompaloompas_working)
        }

        OompaLoompaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
