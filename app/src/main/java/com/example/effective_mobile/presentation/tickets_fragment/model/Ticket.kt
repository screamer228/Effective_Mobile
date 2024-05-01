package com.example.effective_mobile.presentation.tickets_fragment.model

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: String,
    val timeRange: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val travelTime: String,
    val hasTransfer: Boolean
)
