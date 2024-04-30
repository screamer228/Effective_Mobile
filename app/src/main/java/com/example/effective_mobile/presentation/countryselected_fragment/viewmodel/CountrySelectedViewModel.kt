package com.example.effective_mobile.presentation.countryselected_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effective_mobile.domain.TicketsOffersRepository
import com.example.effective_mobile.presentation.countryselected_fragment.uistate.CountrySelectedUiState
import com.example.effective_mobile.presentation.mapper.TicketsOfferMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountrySelectedViewModel @Inject constructor(
    private val ticketsOffersRepository: TicketsOffersRepository,
    private val ticketsOfferMapper: TicketsOfferMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountrySelectedUiState())
    val uiState: StateFlow<CountrySelectedUiState> = _uiState.asStateFlow()

    init {
        getTicketsOffers()
    }

    private fun getTicketsOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            val offerList = ticketsOffersRepository.getTicketsOffers()
            val mappedOfferList = ticketsOfferMapper.mapDtoToUiList(offerList)
            _uiState.value = _uiState.value.copy(ticketsOffersList = mappedOfferList)
        }
    }

}