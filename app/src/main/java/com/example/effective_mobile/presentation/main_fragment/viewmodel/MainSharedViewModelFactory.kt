package com.example.effective_mobile.presentation.main_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.domain.SharedPrefsRepository
import com.example.effective_mobile.presentation.mapper.OfferMapper

class MainSharedViewModelFactory(
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val offersRepository: OffersRepository,
    private val offerMapper: OfferMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainSharedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainSharedViewModel(sharedPrefsRepository, offersRepository, offerMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}