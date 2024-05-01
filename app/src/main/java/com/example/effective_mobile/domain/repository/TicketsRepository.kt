package com.example.effective_mobile.domain.repository

import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO

interface TicketsRepository {

    suspend fun getTickets() : TicketsDTO

}