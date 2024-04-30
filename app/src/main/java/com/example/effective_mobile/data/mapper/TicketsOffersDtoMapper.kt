package com.example.effective_mobile.data.mapper

import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOfferDTO
import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOffersDTO
import com.example.effective_mobile.data.ticketsoffers.response.TicketsOffersResponse

class TicketsOffersDtoMapper {

    fun mapTicketsOffersDto(response: TicketsOffersResponse): TicketsOffersDTO {
        val mappedOffers = response.ticketsOffersResponse.map { ticketsOfferResponse ->
            TicketsOfferDTO(
                ticketsOfferResponse.title,
                ticketsOfferResponse.price.value.toString(),
                ticketsOfferResponse.timeRange.joinToString("  ")
            )
        }
        return TicketsOffersDTO(mappedOffers)
    }
}