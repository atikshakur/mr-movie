package com.example.mrmovie.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mrmovie.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: DiscoverViewPagerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = DiscoverViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.discoverTabLayout, binding.viewPager) { tab, position ->
            when(position){
                0 ->{
                    tab.text = "Movies"
                }
                1 ->{
                    tab.text = "Tv Shows"
                }
                2 ->{
                    tab.text = "Documentary"
                }
                3 ->{
                    tab.text = "Sports"
                }
            }
        }.attach()
    }
}