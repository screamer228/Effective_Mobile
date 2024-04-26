package com.example.effective_mobile.data.offers.model.dto

data class OfferDTO(
    val imageUrl: String,
    val title: String,
    val town: String,
    val price: PriceDTO,
)
