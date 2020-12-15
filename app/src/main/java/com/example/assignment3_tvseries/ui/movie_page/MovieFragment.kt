package com.example.assignment3_tvseries.ui.movie_page

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3_tvseries.R
import androidx.navigation.fragment.findNavController
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel
import com.example.assignment3_tvseries.data_base_network.model.Movy

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private var moviesList = mutableListOf<Movy>()
    private lateinit var movieAdapter: MoviesRecyclerviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            movieAdapter = MoviesRecyclerviewAdapter(moviesList, object : DetailedMovieListener {
                override fun detailedViewClick(position: Int) {
                    Log.d("positionAPTagTag", position.toString())
                    val bundle = Bundle()
                    bundle.putInt("positionAPTagID", position)
                    findNavController().navigate(R.id.action_MovieFragment_to_MovieDetailedFragment,bundle)
                }
            })
            findViewById<RecyclerView>(R.id.recyclerView).apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = movieAdapter
            }
            getRequestMovies()
        }
    }

    private fun getRequestMovies() {
        DataLoader.getRequestForMovies(object : FutureCallbackMovieBridge {
            override fun onResponse(response: MovieInfoModel) {
                d("wordTag", response.toString())
                moviesList.addAll(response.movies)
                movieAdapter.notifyDataSetChanged()
            }

            override fun onFailure(error: String) {
                d("wordTag", error)
            }
        })

    }
}