package com.example.effective_mobile.presentation.mapper

import com.example.effective_mobile.data.offers.model.dto.OfferDTO
import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.presentation.model.Offer

class OfferMapper {

    fun mapDtoToUiList(dto: OffersDTO): List<Offer> {
        return dto.offers.map {
            mapDtoToUi(it)
        }
    }

    fun mapDtoToUi(dto: OfferDTO): Offer {
        return Offer(
            imageUrl = dto.imageUrl,
            title = dto.title,
            town = dto.town,
            price = dto.price.value.toString()
        )
    }
}