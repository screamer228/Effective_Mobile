package com.example.effective_mobile.host

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.effective_mobile.R
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.ActivityHostBinding
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModel
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModelFactory
import javax.inject.Inject

class HostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding
    private lateinit var navController: NavController

    @Inject
    lateinit var mainSharedViewModelFactory: MainSharedViewModelFactory
    private lateinit var mainSharedViewModel: MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavController()

        (applicationContext as App).appComponent.injectHostActivity(this)
        mainSharedViewModel =
            ViewModelProvider(this, mainSharedViewModelFactory)[MainSharedViewModel::class.java]
    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
    }

    fun hideBottomNavigation() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNavigation() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}