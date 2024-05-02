package com.example.effective_mobile.domain.usecase.getticketsoffers

import com.example.effective_mobile.domain.entity.TicketEntity
import com.example.effective_mobile.domain.repository.TicketsRepository
import javax.inject.Inject

class GetTicketsUseCaseImpl @Inject constructor(
    private val ticketsRepository: TicketsRepository
) : GetTicketsUseCase {

    override suspend fun getTickets(): List<TicketEntity> {
        return ticketsRepository.getTickets()
    }
}