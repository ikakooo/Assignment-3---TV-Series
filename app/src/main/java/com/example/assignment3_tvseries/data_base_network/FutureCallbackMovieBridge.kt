package com.example.assignment3_tvseries.data_base_network

import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel


interface FutureCallbackMovieBridge {
    fun onResponse(response: MovieInfoModel)
    fun onFailure(error: String)
}