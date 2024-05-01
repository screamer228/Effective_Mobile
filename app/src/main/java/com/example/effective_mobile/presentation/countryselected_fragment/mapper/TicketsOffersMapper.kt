package com.example.effective_mobile.presentation.countryselected_fragment.mapper

import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOfferDTO
import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOffersDTO
import com.example.effective_mobile.presentation.countryselected_fragment.model.TicketsOffer
import com.example.effective_mobile.utils.StringsUtils.addSpaceEveryThreeDigits

class TicketsOffersMapper {

    fun mapDtoToUiList(dto: TicketsOffersDTO): List<TicketsOffer> {
        return dto.ticketsOffers.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(dto: TicketsOfferDTO): TicketsOffer {
        return TicketsOffer(
            title = dto.title,
            price = addSpaceEveryThreeDigits(dto.price),
            timeRange = dto.timeRange
        )
    }
}