package com.example.mrmovie.home.movies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mrmovie.home.movies.repo.MoviesRepository
import com.example.mrmovie.home.movies.models.MoviesInTheatres
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MoviesFragmentViewModel: ViewModel() {

    private val movieRepo = MoviesRepository()

    fun getMoviesInTheatre(): LiveData<MoviesInTheatres> {
        var response = MutableLiveData<MoviesInTheatres>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = movieRepo.getMoviesInTheatre()
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