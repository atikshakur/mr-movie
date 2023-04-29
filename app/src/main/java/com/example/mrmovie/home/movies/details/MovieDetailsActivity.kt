package com.example.mrmovie.home.movies.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mrmovie.databinding.ActivityMovieDetailsBinding
import com.example.mrmovie.home.movies.details.viewmodels.MovieDetailsViewModel
import com.example.mrmovie.utils.Constants
import kotlinx.coroutines.launch

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private val viewModel: MovieDetailsViewModel by viewModels()
    private lateinit var movieID: String
    private lateinit var adapter: RelatedMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        movieID = intent.extras?.getString(Constants.MOVIE_ID).toString()


        setupUI()
    }

    private fun setupUI() {
        lifecycleScope.launch {
            viewModel.getMovieDetails(movieID.toInt()).observe(this@MovieDetailsActivity) { movieDetails ->
                binding.apply {
                    progressBar.visibility = View.GONE
                    ui.visibility = View.VISIBLE
                    Glide.with(this@MovieDetailsActivity)
                        .load("https://image.tmdb.org/t/p/w500${movieDetails.backdrop_path}")
                        .into(movieBackdrop)

                    movieTitle.text = movieDetails.title
                    runtime.text = "${movieDetails.runtime} minutes"
                    rating.text = movieDetails.vote_average.toString()
                    releaseDate.text = movieDetails.release_date
                    genres.text = movieDetails.genres[0].name
                    synopsis.text = movieDetails.overview
                }
            }
        }
        lifecycleScope.launch {
            viewModel.getSimilarMovies(movieID.toInt()).observe(this@MovieDetailsActivity) { similarMovies ->
                adapter = RelatedMovieAdapter(this@MovieDetailsActivity, similarMovies)
                binding.relatedMoviesRecyclerview.layoutManager = LinearLayoutManager(this@MovieDetailsActivity, LinearLayoutManager.HORIZONTAL, false)
                binding.relatedMoviesRecyclerview.adapter = adapter
            }
        }
    }
}