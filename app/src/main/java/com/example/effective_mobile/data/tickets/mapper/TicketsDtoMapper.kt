package com.example.effective_mobile.data.tickets.mapper

import com.example.effective_mobile.data.tickets.model.dto.TicketDTO
import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO
import com.example.effective_mobile.data.tickets.model.response.TicketsResponse

class TicketsDtoMapper {

    fun mapTicketsDto(response: TicketsResponse): TicketsDTO {
        val mappedList = response.ticketsResponse.map { ticketsResponse ->
            TicketDTO(
                ticketsResponse.id,
                ticketsResponse.badge,
                ticketsResponse.price.value.toString(),
                ticketsResponse.arrival.date,
                ticketsResponse.departure.date,
                ticketsResponse.departure.airport,
                ticketsResponse.arrival.airport,
                ticketsResponse.hasTransfer
            )
        }
        return TicketsDTO(mappedList)
    }
}