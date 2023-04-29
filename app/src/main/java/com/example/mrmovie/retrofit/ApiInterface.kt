package com.example.mrmovie.retrofit

import androidx.annotation.Keep
import com.example.mrmovie.home.movies.models.MovieDetails
import com.example.mrmovie.home.movies.models.MoviesInTheatres
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

@Keep
interface ApiInterface {

    @GET("discover/movie?api_key=cd890f94a756b1518a2a17617a5b430e&primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22")
    suspend fun getMoviesInTheatres(): Response<MoviesInTheatres>

    @GET("movie/{movie_id}?api_key=cd890f94a756b1518a2a17617a5b430e")
    suspend fun getMovieDetails(@Path("movie_id") movieID: String): Response<MovieDetails>

    @GET("movie/{movie_id}/similar?api_key=cd890f94a756b1518a2a17617a5b430e")
    suspend fun getSimilarMovies(@Path("movie_id") movieID: String): Response<MoviesInTheatres>
}