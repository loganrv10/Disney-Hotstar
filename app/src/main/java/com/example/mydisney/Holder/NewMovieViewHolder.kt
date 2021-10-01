package com.example.mydisney.Holder

import android.R
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.Glide

import com.example.mydisney.Model.NowShowingDTO

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.new_shows.view.*


class NewMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun setData(nowShowingDTO: NowShowingDTO) {

        itemView.apply {
            Glide.with(imagePoster).load(nowShowingDTO.posterurl).into(imagePoster)
        }



        }
    }

