package com.example.effective_mobile.domain.repository

import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOffersDTO

interface TicketsOffersRepository {

    suspend fun getTicketsOffers() : TicketsOffersDTO

}