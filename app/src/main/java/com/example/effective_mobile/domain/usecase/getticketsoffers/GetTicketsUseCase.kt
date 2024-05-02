package com.example.effective_mobile.domain.usecase.getticketsoffers

import com.example.effective_mobile.domain.entity.TicketEntity

interface GetTicketsUseCase {

    suspend fun getTickets() : List<TicketEntity>

}