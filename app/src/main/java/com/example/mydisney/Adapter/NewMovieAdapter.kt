package com.example.mydisney.Adapter

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mydisney.Holder.NewMovieViewHolder
import com.example.mydisney.Model.NowShowingDTO

import java.util.ArrayList;


 class NewMovieAdapter(var list: List<NowShowingDTO>):
    RecyclerView.Adapter<NewMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(com.example.mydisney.R.layout.new_shows, parent, false)

        return NewMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewMovieViewHolder, position: Int) {
        holder.setData(NowShowingDTO())
    }

    override fun getItemCount(): Int {
        return list.size
    }


}