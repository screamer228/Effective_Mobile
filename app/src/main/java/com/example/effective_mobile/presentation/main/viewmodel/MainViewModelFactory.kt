package com.example.effective_mobile.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.presentation.mapper.OfferMapper

class MainViewModelFactory(
    val offersRepository: OffersRepository,
    val offerMapper: OfferMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            offersRepository,
            offerMapper
        ) as T
    }
}