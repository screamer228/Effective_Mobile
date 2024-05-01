package com.example.effective_mobile.presentation.tickets_fragment.uistate

import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket

data class TicketsUiState(
    val townsTitle: String = "",
    val dateTitle: String = "",
    val ticketsList: List<Ticket> = listOf()
)
