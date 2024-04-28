package com.example.effective_mobile.presentation.main.uistate

sealed class MainNavigationEvent {
    data object ToFragmentSearch : MainNavigationEvent()
    data object ResetNavigation : MainNavigationEvent()
}