package com.example.effective_mobile.presentation.countryselected_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.usecase.getlastinput.GetLastInputUseCase
import com.example.effective_mobile.domain.usecase.gettickets.GetTicketsOffersUseCase
import com.example.effective_mobile.presentation.countryselected_fragment.mapper.TicketsOffersMapper

class CountrySelectedViewModelFactory(
    private val getLastInputUseCase: GetLastInputUseCase,
    private val getTicketsOffersUseCase: GetTicketsOffersUseCase,
    private val ticketsOfferMapper: TicketsOffersMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountrySelectedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountrySelectedViewModel(
                getLastInputUseCase,
                getTicketsOffersUseCase,
                ticketsOfferMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}