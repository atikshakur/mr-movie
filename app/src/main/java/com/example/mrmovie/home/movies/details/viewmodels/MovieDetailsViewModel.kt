package com.example.mrmovie.home.movies.details.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mrmovie.home.movies.details.repo.MovieDetailsRepository
import com.example.mrmovie.home.movies.models.MovieDetails
import com.example.mrmovie.home.movies.repo.MoviesRepository
import com.example.mrmovie.home.movies.models.MoviesInTheatres
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MovieDetailsViewModel: ViewModel() {

    private val movieRepo = MovieDetailsRepository()

    fun getMovieDetails(movieID: Int): LiveData<MovieDetails> {
        var response = MutableLiveData<MovieDetails>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = movieRepo.getMovieDetails(movieID)
                when (res.isSuccessful) {
                    true -> response.postValue(res.body())
                    else -> response.postValue(MovieDetails())
                }
            } catch (e: UnknownHostException) {
                response.postValue(MovieDetails())
            }
        }
        return response
    }

    fun getSimilarMovies(movieID: Int): LiveData<MoviesInTheatres> {
        var response = MutableLiveData<MoviesInTheatres>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = movieRepo.getSimilarMovies(movieID)
                when (res.isSuccessful) {
                    true -> response.postValue(res.body())
                    else -> response.postValue(MoviesInTheatres())
                }
            } catch (e: UnknownHostException) {
                response.postValue(MoviesInTheatres())
            }
        }
        return response
    }
}