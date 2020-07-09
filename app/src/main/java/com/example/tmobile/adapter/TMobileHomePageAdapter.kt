package com.example.tmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobile.R
import com.example.tmobile.model.Cards
import com.example.tmobile.model.ImageDownloaderOptions
import com.example.tmobile.repository.ImageDownloaderRepository

class TMobileHomePageAdapter(
    data: List<Cards>,
    imageLoader: ImageDownloaderRepository
) : RecyclerView.Adapter<TMobileHomePageAdapter.HomePageViewHolder>() {

    private val dataList: List<Cards> = data
    private val mImageLoader = imageLoader
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tmobile_adapter_cell, parent, false)
        return HomePageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.bindView(dataList[position],mImageLoader)
    }

    inner class HomePageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView
        private val title: TextView

        init {
            view.apply {
                image = findViewById(R.id.tmobile_image)
                title = findViewById(R.id.tmobile_image_title)
            }
        }

        fun bindView(
            item: Cards,
            mImageLoader: ImageDownloaderRepository
        ) {
            itemView.apply {
                title.text = item.card_type
                item.card?.image?.url?.let {
                    mImageLoader.displayImage(
                        ImageDownloaderOptions(
                            it
                        ),
                        image,
                        context
                    )
                }
            }
        }
    }
}