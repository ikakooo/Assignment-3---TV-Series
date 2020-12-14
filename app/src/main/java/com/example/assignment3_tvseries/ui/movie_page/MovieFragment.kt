package com.example.assignment3_tvseries.ui.movie_page

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private var moviesList = mutableListOf<MovieInfoModel>()
    private lateinit var movieAdapter: MoviesRecyclerviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            getRequestMovies()
            findViewById<Button>(R.id.button_first).setOnClickListener {
                findNavController().navigate(R.id.action_MovieFragment_to_MovieDetailedFragment)
            }

            movieAdapter = MoviesRecyclerviewAdapter(moviesList, object : DetailedMovieListener {
                override fun detailedViewClick(position: Int) {
//                    val topRatedMovie = topRatedMoviesList[position]
//                    val intent = Intent(context, DetailedMovieActivity::class.java)
//                    intent.putExtra("name", topRatedMovie.original_title)
//                    intent.putExtra("movieID", topRatedMovie.id)
//                    startActivity(intent)
                }

            })
            findViewById<RecyclerView>(R.id.recyclerView).apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                isNestedScrollingEnabled = true
                setHasFixedSize(false)
                adapter = movieAdapter
            }


        }
    }

    private fun View.getRequestMovies() {
        DataLoader.getRequestForMovies(object : FutureCallbackMovieBridge {
            override fun onResponse(response: MovieInfoModel) {
                d("dsfsfdf", response.toString())
                response.toString()
                moviesList.addAll(listOf(response))
                movieAdapter.notifyDataSetChanged()
            }

            override fun onFailure(error: String) {
                d("dsfsfdf", error.toString())
                error
            }
        })

    }
}