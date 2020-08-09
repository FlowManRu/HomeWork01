package com.example.homework01

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val itemsFilm: List<FilmItem>): RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilmViewHolder(inflater.inflate(R.layout.item_film, parent, false))
    }

    override fun getItemCount() = itemsFilm.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bindOne(itemsFilm[position])
    }
}