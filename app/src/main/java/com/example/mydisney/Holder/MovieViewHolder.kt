package com.example.mydisney.Holder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydisney.Model.ComingSoonDTO
import com.example.mydisney.R
import kotlinx.android.synthetic.main.item_coming.view.*
import kotlinx.android.synthetic.main.item_coming.view.comingImage
import kotlinx.android.synthetic.main.new_shows.view.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun setData(comingSoonDTO: ComingSoonDTO) {

    itemView.apply {
        Glide.with(comingImage).load(comingSoonDTO.posterurl).into(comingImage)

    }


    }

}
