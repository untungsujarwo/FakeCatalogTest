package com.untung.fakestoreapp.common.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.untung.fakestoreapp.R

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url.ifBlank { R.drawable.no_image })
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transform(CenterCrop(), RoundedCorners(16))
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(com.google.android.material.R.drawable.mtrl_ic_error).into(this)
}