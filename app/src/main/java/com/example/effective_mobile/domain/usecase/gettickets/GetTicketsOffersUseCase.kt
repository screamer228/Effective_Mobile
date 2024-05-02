package com.example.effective_mobile.domain.usecase.gettickets

import com.example.effective_mobile.domain.entity.TicketsOfferEntity

interface GetTicketsOffersUseCase {

    suspend fun getTicketsOffers() : List<TicketsOfferEntity>

}