package com.example.effective_mobile.data.ticketsoffers.mapper

import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOffersDTO
import com.example.effective_mobile.domain.entity.TicketsOfferEntity

class TicketsOffersEntityMapper {

    fun mapTicketsOffersEntityList(dto: TicketsOffersDTO): List<TicketsOfferEntity> {
        val mappedList = dto.ticketsOffersDto.map { ticketsOfferDto ->
            TicketsOfferEntity(
                ticketsOfferDto.title,
                ticketsOfferDto.price.value.toString(),
                ticketsOfferDto.timeRange.joinToString(" ")
            )
        }
        return mappedList
    }
}