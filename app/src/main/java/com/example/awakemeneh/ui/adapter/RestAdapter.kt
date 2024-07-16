package com.example.awakemeneh.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awakemeneh.R
import com.example.awakemeneh.ui.data.RestArea
import com.example.awakemeneh.ui.restarea.DetailRest

class RestAdapter(private val cardList: List<RestArea>, private val context: Context) : RecyclerView.Adapter<RestAdapter.RestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restarea, parent, false)
        return RestViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestViewHolder, position: Int) {
        val card = cardList[position]
        holder.bind(card, context)
    }

    override fun getItemCount() = cardList.size

    class RestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.gambarrr)
        private val nameView = itemView.findViewById<TextView>(R.id.namarestarea)
        private val addressView = itemView.findViewById<TextView>(R.id.alamatrest)
        private val coordinatesView = itemView.findViewById<TextView>(R.id.koordinat)
        private val moreInfoView = itemView.findViewById<TextView>(R.id.selengkapnyarest)

        fun bind(card: RestArea, context: Context) {
            imageView.setImageResource(card.imageResId)
            nameView.text = card.name
            addressView.text = card.address
            coordinatesView.text = card.coordinates

            moreInfoView.setOnClickListener {
                val intent = Intent(context, DetailRest::class.java)
                intent.putExtra("REST_AREA_NAME", card.name)
                intent.putExtra("REST_AREA_ADDRESS", card.address)
                intent.putExtra("REST_AREA_COORDINATES", card.coordinates)
                context.startActivity(intent)
            }
        }
    }
}
