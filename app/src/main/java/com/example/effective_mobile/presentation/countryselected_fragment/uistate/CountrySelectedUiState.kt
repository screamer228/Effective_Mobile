package com.example.effective_mobile.presentation.countryselected_fragment.uistate

import com.example.effective_mobile.presentation.countryselected_fragment.model.TicketsOffer

data class CountrySelectedUiState(
    val inputFrom: String = "",
    val inputTo: String = "",
    val ticketsOffersList: List<TicketsOffer> = listOf(),
    val navigation: CountrySelectedNavigationEvent = CountrySelectedNavigationEvent.NoNavigation
)
