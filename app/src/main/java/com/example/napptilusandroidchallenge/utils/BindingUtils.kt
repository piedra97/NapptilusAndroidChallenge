package com.example.napptilusandroidchallenge.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.napptilusandroidchallenge.R
import com.example.napptilusandroidchallenge.network.OompaLoompaApiStatus

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
