package com.example.assignment3_tvseries.data_base_network

import android.util.Log
import com.example.assignment3_tvseries.data_base_network.model.MovieInfoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DataLoader {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/nikoloz14/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(APIService::class.java)


    fun getRequestForMovies(
        callback: FutureCallbackMovieBridge

    ) {
        val call = service.getMovies()
        call.enqueue(object : Callback<MovieInfoModel> {
            override fun onFailure(call: Call<MovieInfoModel>, t: Throwable) {
                callback.onFailure(t.message.toString())
                Log.d("moviesFailure", t.message.toString())
            }

            override fun onResponse(
                call: Call<MovieInfoModel>,
                response: Response<MovieInfoModel>
            ) {
                response.body()?.let { callback.onResponse(it) }
                Log.d("MoviesResponse", response.body().toString())
            }

        })
    }


}