package com.example.effective_mobile.presentation.countryselected.uistate

import com.example.effective_mobile.presentation.main.model.Offer

data class CountrySelectedUiState(
    val inputFrom: String = "",
    val inputTo: String = "",
    val ticketsOffersList: List<Offer> = listOf(),
    val navigation: CountrySelectedNavigationEvent = CountrySelectedNavigationEvent.ResetNavigation
)
