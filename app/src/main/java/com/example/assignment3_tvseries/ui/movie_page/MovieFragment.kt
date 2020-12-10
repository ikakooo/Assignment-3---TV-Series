package com.example.assignment3_tvseries.ui.movie_page

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieFragment : Fragment(R.layout.fragment_movie) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            findViewById<TextView>(R.id.textview_first).apply {

                DataLoader.getRequestForMovies(object :FutureCallbackMovieBridge{
                    override fun onResponse(response: MovieInfoModel) {
                        d("dsfsfdf",response.toString())
                        text = response.toString()
                    }

                    override fun onFailure(error: String) {
                        d("dsfsfdf",error.toString())
                        text = error
                    }

                })

            }


        }

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_MovieFragment_to_MovieDetailedFragment)
        }
    }

    private fun getRequestMovies():String{
        var data = "gdg  "

        return data + "sffsfd"
    }
}