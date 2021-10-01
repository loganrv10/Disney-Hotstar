package com.example.mydisney.Holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydisney.Model.ComingSoonDTO
import kotlinx.android.synthetic.main.item_moviefragment_comingsonn.view.*

class Movie_Coming_soon_holder(itemView: View)  : RecyclerView.ViewHolder(itemView) {

   fun setData(comingSoonDTO: ComingSoonDTO){
       itemView.apply {
           Glide.with(comingImageMovieFragment).load(comingSoonDTO.posterurl).into(comingImageMovieFragment)
       }
   }
}