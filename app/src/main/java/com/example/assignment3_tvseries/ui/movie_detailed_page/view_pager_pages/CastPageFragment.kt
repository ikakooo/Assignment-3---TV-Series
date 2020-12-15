package com.example.assignment3_tvseries.ui.movie_detailed_page.view_pager_pages

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.assignment3_tvseries.R

class CastPageFragment(movieID: Int) : Fragment(R.layout.fragment_cast_page) {
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("fsdfsfsf", "onSaveInstanceState")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {

        }
    }
}