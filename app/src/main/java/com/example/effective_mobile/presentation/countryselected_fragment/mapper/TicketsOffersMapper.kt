package com.example.effective_mobile.presentation.countryselected_fragment.mapper

import com.example.effective_mobile.domain.entity.TicketsOfferEntity
import com.example.effective_mobile.presentation.countryselected_fragment.model.TicketsOffer
import com.example.effective_mobile.utils.StringsUtils.addSpaceEveryThreeDigits

class TicketsOffersMapper {

    fun mapDtoToUiList(entityList: List<TicketsOfferEntity>): List<TicketsOffer> {
        return entityList.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(entity: TicketsOfferEntity): TicketsOffer {
        return TicketsOffer(
            title = entity.title,
            price = addSpaceEveryThreeDigits(entity.price),
            timeRange = entity.timeRange
        )
    }
}