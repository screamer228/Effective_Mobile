package com.example.effective_mobile.presentation.main.uistate

import com.example.effective_mobile.presentation.model.Offer

data class MainUiState(
    val inputFrom: String = "",
    val inputTo: String = "",
    val offersList: List<Offer> = listOf(),
    val navigation: MainNavigationEvent = MainNavigationEvent.ResetNavigation
)
