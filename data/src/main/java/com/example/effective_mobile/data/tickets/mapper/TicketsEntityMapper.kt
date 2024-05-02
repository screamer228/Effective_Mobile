package com.example.effective_mobile.data.tickets.mapper

import com.example.effective_mobile.data.tickets.dto.TicketsDTO
import com.example.effective_mobile.domain.entity.TicketEntity

class TicketsEntityMapper {

    fun mapTicketsDto(dto: TicketsDTO): List<TicketEntity> {
        val mappedList = dto.ticketsDto.map { ticketDto ->
            TicketEntity(
                ticketDto.id,
                ticketDto.badge,
                ticketDto.price.value.toString(),
                ticketDto.arrival.date,
                ticketDto.departure.date,
                ticketDto.departure.airport,
                ticketDto.arrival.airport,
                ticketDto.hasTransfer
            )
        }
        return mappedList
    }
}