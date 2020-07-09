package com.example.tmobile.model

import android.graphics.drawable.Drawable

data class ImageDownloaderOptions(
    val url: String,
    val placeholder: Drawable? = null
)