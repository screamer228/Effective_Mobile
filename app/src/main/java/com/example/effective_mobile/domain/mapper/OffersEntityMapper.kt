package com.example.effective_mobile.domain.mapper

import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.domain.entity.OfferEntity

class OffersEntityMapper {

    fun mapOffersEntityList(dto: OffersDTO): List<OfferEntity> {
        val mappedList = dto.offers.map { offerDTO ->
            OfferEntity(
                offerDTO.imageUrl,
                offerDTO.title,
                offerDTO.town,
                offerDTO.price
            )
        }
        return mappedList
    }
}