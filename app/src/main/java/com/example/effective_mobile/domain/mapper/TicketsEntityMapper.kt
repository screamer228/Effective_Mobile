package com.example.effective_mobile.domain.mapper

import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO
import com.example.effective_mobile.domain.entity.TicketEntity

class TicketsEntityMapper {

    fun mapTicketsEntityList(dto: TicketsDTO): List<TicketEntity> {
        val mappedList = dto.tickets.map { ticketDTO ->
            TicketEntity(
                ticketDTO.id,
                ticketDTO.badge,
                ticketDTO.price,
                ticketDTO.departureDate,
                ticketDTO.arrivalDate,
                ticketDTO.departureAirport,
                ticketDTO.arrivalAirport,
                ticketDTO.hasTransfer
            )
        }
        return mappedList
    }
}