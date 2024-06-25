package com.example.awakemeneh.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awakemeneh.R
import com.example.awakemeneh.ui.data.Card

class CardAdapter(private val cardList: List<Card>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.cardTitle.text = card.title
        holder.cardAddress.text = card.address
        holder.cardRating.text = card.rating
        holder.cardDistanceTime.text = card.distanceTime
        holder.cardType.text = card.type
        holder.cardImage.setImageResource(card.imageResource)
    }

    override fun getItemCount() = cardList.size

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImage: ImageView = itemView.findViewById(R.id.card_image)
        val cardTitle: TextView = itemView.findViewById(R.id.card_title)
        val cardAddress: TextView = itemView.findViewById(R.id.card_address)
        val cardRating: TextView = itemView.findViewById(R.id.card_rating)
        val cardDistanceTime: TextView = itemView.findViewById(R.id.card_distance_time)
        val cardType: TextView = itemView.findViewById(R.id.card_type)
    }
}
