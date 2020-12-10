package com.example.assignment3_tvseries.data_base_network


import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("nikoloz14/movies-db/db")
    fun getMovies(): Call<MovieInfoModel>
}