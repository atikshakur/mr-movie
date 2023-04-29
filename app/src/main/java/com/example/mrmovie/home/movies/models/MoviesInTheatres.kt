package com.example.mrmovie.home.movies.models

import androidx.annotation.Keep

@Keep
data class MoviesInTheatres(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
) {
    constructor() : this (
        0,
        emptyList(),
        0,
        0
            )
}