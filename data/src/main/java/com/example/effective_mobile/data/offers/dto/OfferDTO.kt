package com.example.effective_mobile.data.offers.dto

data class OfferDTO(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceDTO,
)