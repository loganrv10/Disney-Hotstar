package com.example.mydisney.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydisney.Holder.Movie_Coming_soon_holder
import com.example.mydisney.Model.ComingSoonDTO
import com.example.mydisney.R

class MovieFragmentComingSoonAdapter(var comMovieFragmentList: List<ComingSoonDTO>):
    RecyclerView.Adapter<Movie_Coming_soon_holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Movie_Coming_soon_holder {
     var view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_moviefragment_comingsonn,parent,false)
                return Movie_Coming_soon_holder(view)
    }

    override fun onBindViewHolder(holder: Movie_Coming_soon_holder, position: Int) {
        val comingSoonDTO : ComingSoonDTO = comMovieFragmentList[position]
        holder.setData(comingSoonDTO)
    }

    override fun getItemCount(): Int {
       return comMovieFragmentList.size
    }

}