package com.example.tmobile.repository

import android.content.Context
import android.widget.ImageView
import com.example.tmobile.model.ImageDownloaderOptions

interface ImageDownloaderRepository {
    fun displayImage(
        imageOptions: ImageDownloaderOptions,
        imageView: ImageView,
        context: Context
    )
}