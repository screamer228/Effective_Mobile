package com.example.effective_mobile.domain.usecase.gettickets

import com.example.effective_mobile.domain.repository.TicketsOffersRepository
import javax.inject.Inject

class GetTicketsOffersUseCaseImpl @Inject constructor(
    private val ticketsOffersRepository: TicketsOffersRepository
) : GetTicketsOffersUseCase {

    override suspend fun getTicketsOffers(): List<com.example.effective_mobile.domain.entity.TicketsOfferEntity> {
        return ticketsOffersRepository.getTicketsOffers()
    }
}