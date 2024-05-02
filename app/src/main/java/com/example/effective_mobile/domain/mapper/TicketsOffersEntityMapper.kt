package com.example.effective_mobile.domain.mapper

import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOffersDTO
import com.example.effective_mobile.domain.entity.TicketsOfferEntity

class TicketsOffersEntityMapper {

    fun mapTicketsOffersEntityList(dto: TicketsOffersDTO): List<TicketsOfferEntity> {
        val mappedList = dto.ticketsOffers.map { ticketsOfferDTO ->
            TicketsOfferEntity(
                ticketsOfferDTO.title,
                ticketsOfferDTO.price,
                ticketsOfferDTO.timeRange
            )
        }
        return mappedList
    }
}