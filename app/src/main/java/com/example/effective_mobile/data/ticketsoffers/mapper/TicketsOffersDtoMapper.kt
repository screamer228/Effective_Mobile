package com.example.effective_mobile.data.ticketsoffers.mapper

import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOfferDTO
import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOffersDTO
import com.example.effective_mobile.data.ticketsoffers.model.response.TicketsOffersResponse

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