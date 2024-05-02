package com.example.effective_mobile.presentation.main_fragment.mapper

import com.example.effective_mobile.domain.entity.OfferEntity
import com.example.effective_mobile.presentation.main_fragment.model.Offer
import com.example.effective_mobile.utils.StringsUtils.addSpaceEveryThreeDigits

class OffersMapper {

    fun mapDtoToUiList(entityList: List<OfferEntity>): List<Offer> {
        return entityList.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(entity: OfferEntity): Offer {
        return Offer(
            imageUrl = entity.imageUrl,
            title = entity.title,
            town = entity.town,
            price = addSpaceEveryThreeDigits(entity.price)
        )
    }
}