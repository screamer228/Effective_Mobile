package com.example.effective_mobile.domain.repository

import com.example.effective_mobile.domain.entity.TicketEntity

interface TicketsRepository {

    suspend fun getTickets(): List<TicketEntity>

}