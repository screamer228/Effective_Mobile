package com.example.effective_mobile.data.tickets.dto

import com.google.gson.annotations.SerializedName

data class HandLuggage(
    @SerializedName("has_hand_luggage") val hasHandLuggage: Boolean,
    val size: String
)