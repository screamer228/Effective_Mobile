package com.example.effective_mobile.presentation.main_fragment.mapper

import com.example.effective_mobile.data.offers.model.dto.OfferDTO
import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.presentation.main_fragment.model.Offer

class OffersMapper {

    fun mapDtoToUiList(dto: OffersDTO): List<Offer> {
        return dto.offers.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(dto: OfferDTO): Offer {
        return Offer(
            imageUrl = dto.imageUrl,
            title = dto.title,
            town = dto.town,
            price = dto.price
        )
    }
}