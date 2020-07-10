package com.example.tmobile.adapter

import android.graphics.Color
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
        holder.bindView(dataList[position], mImageLoader)
    }

    inner class HomePageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView
        private val title: TextView
        private val description : TextView

        init {
            view.apply {
                imageView = findViewById(R.id.tmobile_image)
                title = findViewById(R.id.tmobile_image_title)
                description = findViewById(R.id.tmobile_descripton)
            }
        }

        fun bindView(
            item: Cards,
            mImageLoader: ImageDownloaderRepository
        ) {
            itemView.apply {

                title.apply outer@{
                    item.card?.apply {
                        text = value ?: title?.value
                        val textColor = attributes?.text_color ?: title?.attributes?.text_color
                        setTextColor(Color.parseColor(textColor ?: "#000000"))
                        textSize = attributes?.font?.size ?: title?.attributes?.font?.size ?: 25f
                    }
                }
                description.apply outer@ {
                    item.card?.description?.apply {
                        text = value
                        val textColor = attributes.text_color
                        setTextColor(Color.parseColor(textColor ?: "#000000"))
                        textSize = attributes.font?.size ?: 20f
                    }
                }

                imageView.apply outer@{
                    item.card?.apply {

                        val height = 1498

                        val width = 1170

                        requestLayout()

                        layoutParams.height = height

                        layoutParams.width = width

                        scaleType = ImageView.ScaleType.FIT_XY

                        image?.url?.let {
                            mImageLoader.displayImage(
                                ImageDownloaderOptions(
                                    it
                                ),
                                this@outer,
                                context
                            )
                        }
                    }
                }

            }
        }
    }
}