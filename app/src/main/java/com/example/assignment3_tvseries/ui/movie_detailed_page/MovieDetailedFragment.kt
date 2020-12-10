package com.example.assignment3_tvseries.ui.movie_detailed_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.assignment3_tvseries.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailedFragment : Fragment(R.layout.fragment_movie_detailed) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}