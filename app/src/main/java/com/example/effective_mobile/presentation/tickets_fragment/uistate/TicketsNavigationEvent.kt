package com.example.effective_mobile.presentation.tickets_fragment.uistate

sealed class TicketsNavigationEvent {
    data object NavigateBack : TicketsNavigationEvent()
    data object NoNavigation : TicketsNavigationEvent()
}