package com.example.assignment3_tvseries.ui.movie_detailed_page.view_pager_pages

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.model.Cast
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel
import com.example.assignment3_tvseries.data_base_network.model.Movy


class MoviesCastsRecyclerviewAdapter(
    val MoviesCastList: MutableList<Cast>
) :
    RecyclerView.Adapter<MoviesCastsRecyclerviewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = MoviesCastList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_items_casts_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var model: Cast

        fun onBind() {
            model = MoviesCastList[adapterPosition]
            itemView.findViewById<TextView>(R.id.actorName_TextView_ID).text = model.fullName
            itemView.findViewById<TextView>(R.id.actorRole_TextView_ID).text = model.role
            Glide.with(itemView.context).load(  model.imageUrl)
                .into(itemView.findViewById(R.id.actorProfilePhoto_ImageView_ID))
        }

    }

}