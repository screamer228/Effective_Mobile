package com.example.effective_mobile.data.offers.dto

import com.google.gson.annotations.SerializedName

data class OffersDTO(
    @SerializedName("offers") val offersDto: List<OfferDTO>
)