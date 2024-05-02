package com.example.effective_mobile.domain.repository

import com.example.effective_mobile.domain.entity.OfferEntity

interface OffersRepository {

    suspend fun getOffers(): List<OfferEntity>

}