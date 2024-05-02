package com.example.effective_mobile.di

import com.example.effective_mobile.host.HostActivity
import com.example.effective_mobile.presentation.plug_fragments.HotelsFragment
import com.example.effective_mobile.presentation.plug_fragments.MapFragment
import com.example.effective_mobile.presentation.plug_fragments.ProfileFragment
import com.example.effective_mobile.presentation.search_fragment.SearchFragment
import com.example.effective_mobile.presentation.plug_fragments.SubsFragment
import com.example.effective_mobile.presentation.countryselected_fragment.CountrySelectedFragment
import com.example.effective_mobile.presentation.main_fragment.MainFragment
import com.example.effective_mobile.presentation.tickets_fragment.TicketsFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun injectTicketsFragment(ticketsFragment: TicketsFragment)
    fun injectCountrySelectedFragment(countrySelectedFragment: CountrySelectedFragment)
    fun injectHostActivity(hostActivity: HostActivity)
    fun injectMainFragment(mainFragment: MainFragment)
    fun injectSearchFragment(searchFragment: SearchFragment)
    fun injectHotelsFragment(hotelsFragment: HotelsFragment)
    fun injectMapFragment(mapFragment: MapFragment)
    fun injectSubsFragment(subsFragment: SubsFragment)
    fun injectProfileFragment(profileFragment: ProfileFragment)

}