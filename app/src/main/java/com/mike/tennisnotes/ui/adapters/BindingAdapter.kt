package com.mike.tennisnotes.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import timber.log.Timber
import java.io.File


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("localImagePath")
fun bindImageFromLocal(view: ImageView, imagePath: String?) {
    if (!imagePath.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(File(imagePath))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }else{
        Timber.d("empty")
    }
}