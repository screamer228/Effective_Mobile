package com.example.effective_mobile.domain.usecase.getoffers

import com.example.effective_mobile.domain.entity.OfferEntity
import com.example.effective_mobile.domain.mapper.OffersEntityMapper
import com.example.effective_mobile.domain.repository.OffersRepository
import javax.inject.Inject

class GetOffersUseCaseImpl @Inject constructor(
    private val offersRepository: OffersRepository,
    private val offersEntityMapper: OffersEntityMapper
) : GetOffersUseCase {

    override suspend fun getOffers(): List<OfferEntity> {
        val offers = offersRepository.getOffers()
        return offersEntityMapper.mapOffersEntityList(offers)
    }
}