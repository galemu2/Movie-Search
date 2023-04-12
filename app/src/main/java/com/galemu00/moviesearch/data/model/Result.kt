package com.galemu00.moviesearch.data.model

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    // id
    val id: Int,
    val original_language: String,
    val original_title: String,
    // description
    val overview: String,
    val popularity: Double,
    // poster
    val poster_path: String,
    val release_date: String,
    // movie title
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)