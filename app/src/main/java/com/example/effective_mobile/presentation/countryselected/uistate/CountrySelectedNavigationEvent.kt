package com.example.effective_mobile.presentation.countryselected.uistate

sealed class CountrySelectedNavigationEvent {
    data object ToFragmentTickets : CountrySelectedNavigationEvent()
    data object ResetNavigation : CountrySelectedNavigationEvent()
}