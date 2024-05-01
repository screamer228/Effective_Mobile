package com.example.effective_mobile.data.tickets.model.dto

data class TicketDTO(
    val id: Int,
    val badge: String?,
    val price: String,
    val departureDate: String,
    val arrivalDate: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val hasTransfer: Boolean
)
