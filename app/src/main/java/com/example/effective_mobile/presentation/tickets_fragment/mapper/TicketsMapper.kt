package com.example.effective_mobile.presentation.tickets_fragment.mapper

import com.example.effective_mobile.data.tickets.model.dto.TicketDTO
import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO
import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket

class TicketsMapper {

    fun mapDtoToUiList(dto: TicketsDTO): List<Ticket> {
        return dto.tickets.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(dto: TicketDTO): Ticket {
        return Ticket(
            id = dto.id,
            badge = dto.badge,
            price = dto.price,
            timeRange = dto.timeRange,
            departureAirport = dto.departureAirport,
            arrivalAirport = dto.arrivalAirport,
            travelTime = dto.travelTime,
            hasTransfer = dto.hasTransfer
        )
    }
}