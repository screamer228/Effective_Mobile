package com.example.effective_mobile.data.offers.model

data class Offer(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price,
)