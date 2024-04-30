package com.example.effective_mobile.presentation.main_fragment.uistate

sealed class MainNavigationEvent {
    data object ToFragmentSearch : MainNavigationEvent()
    data object ResetNavigation : MainNavigationEvent()
}