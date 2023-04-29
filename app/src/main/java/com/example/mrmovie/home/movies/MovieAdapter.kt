package com.example.mrmovie.home.movies

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mrmovie.databinding.MovieItemBinding
import com.example.mrmovie.home.movies.details.MovieDetailsActivity
import com.example.mrmovie.home.movies.models.MoviesInTheatres
import com.example.mrmovie.utils.Constants

class MovieAdapter(
        private val context: Context,
        private val movies: MoviesInTheatres
    ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500${movies.results[position].poster_path}")
            .into(holder.binding.cover)

        holder.binding.movieName.text = movies.results[position].original_title

        holder.binding.movie.setOnClickListener {
            val intent = Intent(it.context, MovieDetailsActivity::class.java)
            intent.putExtra(Constants.MOVIE_ID, movies.results[position].id.toString())
            Log.d("mrmovie", movies.results[position].id.toString())
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return movies.results.size
    }

    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {}
}