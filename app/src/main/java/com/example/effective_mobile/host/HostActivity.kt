package com.example.effective_mobile.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.effective_mobile.R
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.ActivityHostBinding
import com.example.effective_mobile.presentation.main.viewmodel.MainSharedViewModel
import com.example.effective_mobile.presentation.main.viewmodel.MainSharedViewModelFactory
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

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        (applicationContext as App).appComponent.injectHostActivity(this)

        // Создание MainSharedViewModel
        mainSharedViewModel = ViewModelProvider(this, mainSharedViewModelFactory).get(MainSharedViewModel::class.java)
    }
}