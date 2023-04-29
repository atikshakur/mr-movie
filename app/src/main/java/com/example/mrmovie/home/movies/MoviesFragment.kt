package com.example.mrmovie.home.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mrmovie.databinding.FragmentMoviesBinding
import com.example.mrmovie.home.movies.viewmodels.MoviesFragmentViewModel
import kotlinx.coroutines.launch


class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MoviesFragmentViewModel by activityViewModels()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getMoviesInTheatre().observe(requireActivity()) { movies ->
                binding.progressBar.visibility = View.GONE

                adapter = MovieAdapter(view.context, movies)
                binding.moviesRecyclerview.layoutManager = GridLayoutManager(view.context, 2)
                binding.moviesRecyclerview.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}