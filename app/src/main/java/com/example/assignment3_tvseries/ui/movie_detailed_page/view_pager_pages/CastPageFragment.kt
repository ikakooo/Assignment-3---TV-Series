package com.example.assignment3_tvseries.ui.movie_detailed_page.view_pager_pages

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.Cast
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel
import com.example.assignment3_tvseries.data_base_network.model.Movy
import com.example.assignment3_tvseries.ui.movie_page.DetailedMovieListener
import com.example.assignment3_tvseries.ui.movie_page.MoviesRecyclerviewAdapter

class CastPageFragment(moviePositionID: Int) : Fragment(R.layout.fragment_cast_page) {
    private val movieID = moviePositionID
    private var moviesCastList = mutableListOf<Cast>()
    private lateinit var movieCastAdapter: MoviesCastsRecyclerviewAdapter
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("fsdfsfsf", "onSaveInstanceState")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {

            movieCastAdapter = MoviesCastsRecyclerviewAdapter(moviesCastList)
            findViewById<RecyclerView>(R.id.recyclerView).apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = movieCastAdapter
            }

        }
        getRequestMovies(movieID)
    }

    private fun getRequestMovies(movieID:Int) {
        DataLoader.getRequestForMovies(object : FutureCallbackMovieBridge {
            override fun onResponse(response: MovieInfoModel) {
                Log.d("wordTag", response.toString())
                moviesCastList.addAll(response.movies[movieID].cast)
                movieCastAdapter.notifyDataSetChanged()
            }

            override fun onFailure(error: String) {
                Log.d("wordTag", error)
            }
        })

    }
}