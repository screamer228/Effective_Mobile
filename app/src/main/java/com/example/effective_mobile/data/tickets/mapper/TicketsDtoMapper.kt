package com.example.effective_mobile.data.tickets.mapper

import android.util.Log
import com.example.effective_mobile.data.tickets.model.dto.TicketDTO
import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO
import com.example.effective_mobile.data.tickets.model.response.TicketsResponse

class TicketsDtoMapper {

    fun mapTicketsOffersDto(response: TicketsResponse): TicketsDTO {
        val mappedOffers = response.ticketsResponse.map { ticketsResponse ->
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
        Log.d("transfer check", "in dtoMapper: ${mappedOffers.first().hasTransfer}")
        return TicketsDTO(mappedOffers)
    }
}