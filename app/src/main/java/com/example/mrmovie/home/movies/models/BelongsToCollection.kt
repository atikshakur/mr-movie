package com.example.mrmovie.home.movies.models

import androidx.annotation.Keep

@Keep
data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
) {
    constructor() : this (
        "",
        0,
        "",
        ""
            )
}