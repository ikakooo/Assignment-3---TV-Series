package com.example.assignment3_tvseries.ui.movie_detailed_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.assignment3_tvseries.R
import com.example.assignment3_tvseries.data_base_network.DataLoader
import com.example.assignment3_tvseries.data_base_network.FutureCallbackMovieBridge
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel
import com.example.assignment3_tvseries.ui.movie_detailed_page.view_pager_pages.MyViewPagerAdapter
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailedFragment : Fragment(R.layout.fragment_movie_detailed) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
                ///findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                val viewPager = findViewById<ViewPager>(R.id.view_pager)
                val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

                val adapter = activity?.supportFragmentManager?.let { MyViewPagerAdapter(it) }
                viewPager.adapter = adapter

                tabLayout.setupWithViewPager(viewPager)
        }
       // getRequestMovies()
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