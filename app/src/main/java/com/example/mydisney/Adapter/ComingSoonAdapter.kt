package com.example.mydisney.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydisney.Holder.MovieViewHolder
import com.example.mydisney.Model.ComingSoonDTO
import com.example.mydisney.R
import java.util.ArrayList


class ComingSoonAdapter(var comeMovieList: List<ComingSoonDTO>) :
    RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coming, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val comingSoonDTO: ComingSoonDTO = comeMovieList[position]
        holder.setData(comingSoonDTO)
    }

    override fun getItemCount(): Int {
        return comeMovieList.size
    }

    init {
        this.comeMovieList = comeMovieList
    }
}
