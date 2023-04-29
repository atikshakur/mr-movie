package com.example.mrmovie.home.movies.details.repo

import android.util.Log
import com.example.mrmovie.home.movies.models.MovieDetails
import com.example.mrmovie.home.movies.models.MoviesInTheatres
import com.example.mrmovie.retrofit.ApiInterface
import com.example.mrmovie.retrofit.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class MovieDetailsRepository {

    private lateinit var api: ApiInterface
    private val TAG = "MoviesRepository"

    suspend fun getMovieDetails(movieID: Int): Response<MovieDetails> {

        api = ApiUtils.getInstance()
        lateinit var response: Response<MovieDetails>

        withContext(Dispatchers.IO) {
            try {
                response = api.getMovieDetails(movieID.toString())

            } catch (e: HttpException) {
                Log.d(TAG, e.response().toString())
            }
        }

        return response
    }

    suspend fun getSimilarMovies(movieID: Int): Response<MoviesInTheatres> {

        api = ApiUtils.getInstance()
        lateinit var response: Response<MoviesInTheatres>

        withContext(Dispatchers.IO) {
            try {
                response = api.getSimilarMovies(movieID.toString())

            } catch (e: HttpException) {
                Log.d(TAG, e.response().toString())
            }
        }

        return response
    }
}