package com.example.effective_mobile.data.offers.model.response

data class OfferResponse(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceResponse,
)