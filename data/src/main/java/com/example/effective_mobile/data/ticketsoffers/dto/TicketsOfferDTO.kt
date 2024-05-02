package com.example.effective_mobile.data.ticketsoffers.dto

import com.google.gson.annotations.SerializedName

data class TicketsOfferDTO(
    val id: Int,
    val price: PriceDTO,
    @SerializedName("time_range") val timeRange: List<String>,
    val title: String
)