package com.example.effective_mobile.data.ticketsoffers

data class TicketsOffer(
    val id: Int,
    val price: Price,
    val time_range: List<String>,
    val title: String
)