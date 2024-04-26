package com.example.effective_mobile.domain

import com.example.effective_mobile.data.offers.model.dto.OffersDTO

interface OffersRepository {

    fun getOffers() : OffersDTO

}