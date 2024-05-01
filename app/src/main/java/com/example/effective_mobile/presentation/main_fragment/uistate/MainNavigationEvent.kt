package com.example.effective_mobile.presentation.main_fragment.uistate

sealed class MainNavigationEvent {
    data object ToFragmentSearch : MainNavigationEvent()
    data object ToFragmentCountrySelected : MainNavigationEvent()
    data object ToFragmentHardRoute : MainNavigationEvent()
    data object ToFragmentWeekends : MainNavigationEvent()
    data object ToFragmentHotTickets : MainNavigationEvent()
    data object NoNavigation : MainNavigationEvent()
}