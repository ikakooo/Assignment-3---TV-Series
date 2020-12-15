package com.example.assignment3_tvseries.ui.movie_detailed_page.view_pager_pages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class MyViewPagerAdapter(fragmentManager: FragmentManager, moviePositionID:Int) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val movieID = moviePositionID
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> InfoPageFragment(movieID)
                else -> CastPageFragment(movieID)
            }

    override fun getPageTitle(position: Int): CharSequence? =
            when (position) {
                0 -> "INFO"
                else -> "CAST"
            }

}