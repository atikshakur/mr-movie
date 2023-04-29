package com.example.mrmovie.home.movies.repo

import android.util.Log
import com.example.mrmovie.home.movies.models.MoviesInTheatres
import com.example.mrmovie.retrofit.ApiInterface
import com.example.mrmovie.retrofit.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class MoviesRepository {

    private lateinit var api: ApiInterface
    private val TAG = "MoviesRepository"

    suspend fun getMoviesInTheatre(): Response<MoviesInTheatres> {

        api = ApiUtils.getInstance()
        lateinit var response: Response<MoviesInTheatres>

        withContext(Dispatchers.IO) {
            try {
                response = api.getMoviesInTheatres()

            } catch (e: HttpException) {
                Log.d(TAG, e.response().toString())
            }
        }

        return response
    }
}