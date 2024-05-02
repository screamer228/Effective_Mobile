package com.example.effective_mobile.domain.usecase.getoffers

import com.example.effective_mobile.domain.repository.OffersRepository
import javax.inject.Inject

class GetOffersUseCaseImpl @Inject constructor(
    private val offersRepository: OffersRepository
) : GetOffersUseCase {

    override suspend fun getOffers(): List<com.example.effective_mobile.domain.entity.OfferEntity> {
        return offersRepository.getOffers()
    }
}