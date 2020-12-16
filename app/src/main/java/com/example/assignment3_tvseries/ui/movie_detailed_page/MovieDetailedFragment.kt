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
        val bundle = this.arguments
        val movieID: Int = bundle?.getInt("positionAPTagID") ?: 1
        Log.d("idTag", movieID.toString())
        view.apply {
                val viewPager = findViewById<ViewPager>(R.id.view_pager)
                val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

                val adapter = activity?.supportFragmentManager?.let { MyViewPagerAdapter(it,movieID) }
                viewPager.adapter = adapter

                tabLayout.setupWithViewPager(viewPager)
        }
    }
}