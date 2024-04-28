package com.example.effective_mobile.di

import com.example.effective_mobile.host.HostActivity
import com.example.effective_mobile.presentation.HotelsFragment
import com.example.effective_mobile.presentation.MapFragment
import com.example.effective_mobile.presentation.ProfileFragment
import com.example.effective_mobile.presentation.SearchFragment
import com.example.effective_mobile.presentation.SubsFragment
import com.example.effective_mobile.presentation.main.MainFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectHostActivity(hostActivity: HostActivity)
    fun injectMainFragment(mainFragment: MainFragment)
    fun injectSearchFragment(searchFragment: SearchFragment)
    fun injectHotelsFragment(hotelsFragment: HotelsFragment)
    fun injectMapFragment(mapFragment: MapFragment)
    fun injectSubsFragment(subsFragment: SubsFragment)
    fun injectProfileFragment(profileFragment: ProfileFragment)

}