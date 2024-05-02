package com.example.effective_mobile.data.tickets.dto

import com.google.gson.annotations.SerializedName

data class Luggage(
    @SerializedName("has_luggage") val hasLuggage: Boolean,
    val price: PriceX
)