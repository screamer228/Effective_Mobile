package com.example.effective_mobile.domain.usecase.getticketsoffers

import com.example.effective_mobile.domain.entity.TicketEntity
import com.example.effective_mobile.domain.mapper.TicketsEntityMapper
import com.example.effective_mobile.domain.repository.TicketsRepository
import javax.inject.Inject

class GetTicketsUseCaseImpl @Inject constructor(
    private val ticketsRepository: TicketsRepository,
    private val ticketsEntityMapper: TicketsEntityMapper
) : GetTicketsUseCase {

    override suspend fun getTickets(): List<TicketEntity> {
        val tickets = ticketsRepository.getTickets()
        return ticketsEntityMapper.mapTicketsEntityList(tickets)
    }
}