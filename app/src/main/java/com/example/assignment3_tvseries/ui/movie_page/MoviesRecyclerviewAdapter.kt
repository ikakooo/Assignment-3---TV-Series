package com.example.assignment3_tvseries.ui.movie_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel


class MoviesRecyclerviewAdapter(
    val MoviesList: MutableList<MovieInfoModel>,
    val detailedMovieListener: DetailedMovieListener
) :
    RecyclerView.Adapter<MoviesRecyclerviewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = MoviesList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_items_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var model: MovieInfoModel

        fun onBind() {
            model = MoviesList[adapterPosition]
            itemView.findViewById<TextView>(R.id.title_TextView).text = model.movies[adapterPosition].title
            Glide.with(itemView.context).load(  model.movies[0].imageUrl)
                .into(itemView.findViewById(R.id.backgroundIMG))
            itemView.setOnClickListener {
                detailedMovieListener.detailedViewClick(adapterPosition)
            }
        }

    }

}