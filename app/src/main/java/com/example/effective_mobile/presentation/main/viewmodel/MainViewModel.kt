package com.example.effective_mobile.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.presentation.main.uistate.MainUiState
import com.example.effective_mobile.presentation.mapper.OfferMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val offersRepository: OffersRepository,
    private val offerMapper: OfferMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        getOffers()
    }

    private fun getOffers() {
        val offerList = offersRepository.getOffers()
        val mappedOfferList = offerMapper.mapDtoToUiList(offerList)
        _uiState.value = _uiState.value.copy(offersList = mappedOfferList)
    }

}