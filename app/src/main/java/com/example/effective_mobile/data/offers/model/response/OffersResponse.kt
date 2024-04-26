package com.example.effective_mobile.data.offers.model.response

import com.google.gson.annotations.SerializedName

data class OffersResponse(
    @SerializedName("offers") val offersResponse: List<OfferResponse>
)