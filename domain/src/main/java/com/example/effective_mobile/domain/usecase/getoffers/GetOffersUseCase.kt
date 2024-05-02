package com.example.effective_mobile.domain.usecase.getoffers

import com.example.effective_mobile.domain.entity.OfferEntity

interface GetOffersUseCase {

    suspend fun getOffers(): List<OfferEntity>

}