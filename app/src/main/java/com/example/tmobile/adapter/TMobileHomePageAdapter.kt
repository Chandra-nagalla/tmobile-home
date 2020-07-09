package com.example.tmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobile.R
import com.example.tmobile.model.Cards

class TMobileHomePageAdapter(
    data: List<Cards>
): RecyclerView.Adapter<TMobileHomePageAdapter.HomePageViewHolder>() {

    private val dataList: List<Cards> = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tmobile_adapter_cell , parent, false)
        return HomePageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.bindView(dataList[position])
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

        fun bindView(item: Cards) {
            itemView.apply {
                title.text = item.card_type
            }
        }
    }
}