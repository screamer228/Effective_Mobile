package com.example.effective_mobile.data.ticketsoffers.dto

import com.google.gson.annotations.SerializedName

data class TicketsOffersDTO(
    @SerializedName("tickets_offers") val ticketsOffersDto: List<TicketsOfferDTO>
)