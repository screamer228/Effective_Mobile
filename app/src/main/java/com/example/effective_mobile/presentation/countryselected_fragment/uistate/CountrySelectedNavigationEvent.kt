package com.example.effective_mobile.presentation.countryselected_fragment.uistate

sealed class CountrySelectedNavigationEvent {
    data object ToFragmentTickets : CountrySelectedNavigationEvent()
    data object NavigateBack : CountrySelectedNavigationEvent()
    data object NoNavigation : CountrySelectedNavigationEvent()
}