package com.example.effective_mobile.domain.repository

import com.example.effective_mobile.domain.entity.TicketsOfferEntity


interface TicketsOffersRepository {

    suspend fun getTicketsOffers() : List<TicketsOfferEntity>

}