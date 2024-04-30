package com.example.effective_mobile.presentation.countryselected_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.SharedPrefsRepository
import com.example.effective_mobile.domain.TicketsOffersRepository
import com.example.effective_mobile.presentation.mapper.TicketsOfferMapper

class CountrySelectedViewModelFactory(
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val ticketsOffersRepository: TicketsOffersRepository,
    private val ticketsOfferMapper: TicketsOfferMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountrySelectedViewModel::class.java)) {
            return CountrySelectedViewModel(
                sharedPrefsRepository,
                ticketsOffersRepository,
                ticketsOfferMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}