package com.example.effective_mobile.domain

import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOffersDTO

interface TicketsOffersRepository {

    suspend fun getTicketsOffers() : TicketsOffersDTO

}