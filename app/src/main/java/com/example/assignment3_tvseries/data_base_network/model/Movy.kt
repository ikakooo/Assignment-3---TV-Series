package com.example.assignment3_tvseries.data_base_network.model

data class Movy(
    val cast: List<Cast>,
    val date: String,
    val id: Int,
    val imageUrl: String,
    val language: String,
    val seasons: Int,
    val title: String
)