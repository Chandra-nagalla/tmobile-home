package com.example.tmobile.repository

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tmobile.model.ImageDownloaderOptions

class ImageDownloaderRepositoryImpl
: ImageDownloaderRepository {
    override fun displayImage(
        imageOptions: ImageDownloaderOptions,
        imageView: ImageView,
        context: Context
    ) {
        Glide.with(context)
            .load(imageOptions.url)
            .placeholder(imageOptions.placeholder)
            .into(imageView)
    }
}