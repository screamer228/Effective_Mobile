package com.example.effective_mobile.domain.repository

import com.example.effective_mobile.data.offers.model.dto.OffersDTO

interface OffersRepository {

    suspend fun getOffers() : OffersDTO

}