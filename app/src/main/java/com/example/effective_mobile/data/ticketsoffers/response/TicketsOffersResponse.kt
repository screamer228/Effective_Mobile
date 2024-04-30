package com.example.effective_mobile.data.ticketsoffers.response

import com.google.gson.annotations.SerializedName

data class TicketsOffersResponse(
    @SerializedName("tickets_offers") val ticketsOffersResponse: List<TicketsOfferResponse>
)