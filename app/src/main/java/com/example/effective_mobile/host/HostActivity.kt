package com.example.effective_mobile.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.effective_mobile.R
import com.example.effective_mobile.databinding.ActivityHostBinding
import com.example.effective_mobile.presentation.HotelsFragment
import com.example.effective_mobile.presentation.SubsFragment
import com.example.effective_mobile.presentation.main.MainFragment

class HostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareBottomNav()
    }

    private fun prepareBottomNav() {

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mainFragment -> {
                    loadFragment(MainFragment())
                    true
                }
                R.id.hotelsFragment -> {
                    loadFragment(HotelsFragment())
                    true
                }
                R.id.subsFragment -> {
                    loadFragment(SubsFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.commit()
    }
}