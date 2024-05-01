package com.example.effective_mobile.data.ticketsoffers.model.response

import com.google.gson.annotations.SerializedName

data class TicketsOfferResponse(
    val id: Int,
    val price: PriceResponse,
    @SerializedName("time_range") val timeRange: List<String>,
    val title: String
)