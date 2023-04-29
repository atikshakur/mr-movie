package com.example.mrmovie.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mrmovie.home.documentary.DocumentaryFragment
import com.example.mrmovie.home.movies.MoviesFragment
import com.example.mrmovie.movies.TvFragment
import com.example.mrmovie.home.sports.SportsFragment


class DiscoverViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            1 -> {
                return TvFragment()
            }
            2 -> {
                return DocumentaryFragment()
            }
            3 -> {
                return SportsFragment()
            }
        }
        return MoviesFragment()
    }
}