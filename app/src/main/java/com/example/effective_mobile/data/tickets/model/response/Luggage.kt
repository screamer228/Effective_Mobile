package com.example.effective_mobile.data.tickets.model.response

import com.google.gson.annotations.SerializedName

data class Luggage(
    @SerializedName("has_luggage") val hasLuggage: Boolean,
    val price: PriceX
)