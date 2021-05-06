package com.example.napptilusandroidchallenge.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.napptilusandroidchallenge.R
import com.example.napptilusandroidchallenge.model.OompaLoompa

class BindingUtils {

    @BindingAdapter("oompaLoompaImage")
    fun ImageView.setOompaLoompaImage(item: OompaLoompa) {
        setImageResource(R.drawable.ic_launcher_background)
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
}