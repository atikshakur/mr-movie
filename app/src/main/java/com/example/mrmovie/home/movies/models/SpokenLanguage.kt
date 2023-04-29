package com.example.mrmovie.home.movies.models

import androidx.annotation.Keep

@Keep
data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)