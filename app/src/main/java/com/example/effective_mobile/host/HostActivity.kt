package com.example.effective_mobile.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.effective_mobile.R
import com.example.effective_mobile.databinding.ActivityHostBinding
import com.example.effective_mobile.presentation.HotelsFragment
import com.example.effective_mobile.presentation.MapFragment
import com.example.effective_mobile.presentation.ProfileFragment
import com.example.effective_mobile.presentation.SubsFragment
import com.example.effective_mobile.presentation.main.MainFragment

class HostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

    }
}