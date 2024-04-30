package com.example.effective_mobile.presentation.mapper

import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOfferDTO
import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOffersDTO
import com.example.effective_mobile.presentation.countryselected_fragment.model.TicketsOffer

class TicketsOfferMapper {

    fun mapDtoToUiList(dto: TicketsOffersDTO): List<TicketsOffer> {
        return dto.ticketsOffers.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(dto: TicketsOfferDTO): TicketsOffer {
        return TicketsOffer(
            title = dto.title,
            price = dto.price,
            timeRange = dto.timeRange
        )
    }
}