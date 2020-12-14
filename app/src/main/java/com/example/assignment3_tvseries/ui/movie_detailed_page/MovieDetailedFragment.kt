package com.example.assignment3_tvseries.ui.movie_detailed_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailedFragment : Fragment(R.layout.fragment_movie_detailed) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)


        }
        getRequestMovies()
    }


    private fun getRequestMovies() {
        DataLoader.getRequestForMovies(object : FutureCallbackMovieBridge {
            override fun onResponse(response: MovieInfoModel) {
                Log.d("wordTag", response.toString())
//                moviesList.addAll(response.movies)
//                movieAdapter.notifyDataSetChanged()
            }

            override fun onFailure(error: String) {
                Log.d("wordTag", error)
            }
        })

    }
}