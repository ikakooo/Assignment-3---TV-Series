package com.example.assignment3_tvseries.ui.movie_detailed_page.view_pager_pages

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel

class InfoPageFragment : Fragment(R.layout.fragment_info_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val movieID: Int = bundle?.getInt("positionAPTagID") ?: 1
        Log.d("idTag", movieID.toString())
        view.apply {
            getRequestMovies(movieID)
        }
    }

    private fun View.getRequestMovies(movieID:Int) {
        DataLoader.getRequestForMovies(object : FutureCallbackMovieBridge {
            override fun onResponse(response: MovieInfoModel) {
                Log.d("wordTag", response.toString())

                Glide.with(context).load(response.movies[movieID].imageUrl).into(findViewById(R.id.Movie_ImageViewID))
                findViewById<TextView>(R.id.OriginalTitle_TextViewID).text =
                    response.movies[movieID].title
                findViewById<TextView>(R.id.ReleaseDate_TextViewID).text =
                    response.movies[movieID].date
                findViewById<TextView>(R.id.Language_TextViewID).text =
                    response.movies[movieID].language
                findViewById<TextView>(R.id.Seasons_TextViewID).text =
                    response.movies[movieID].seasons.toString()
            }

            override fun onFailure(error: String) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }
        })

    }

}