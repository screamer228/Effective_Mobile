package com.example.effective_mobile.presentation.main_fragment.uistate

import com.example.effective_mobile.presentation.main_fragment.model.Offer

data class MainUiState(
    val inputFrom: String = "",
    val inputTo: String = "",
    val offersList: List<Offer> = listOf(),
    val navigation: MainNavigationEvent = MainNavigationEvent.ResetNavigation
)
