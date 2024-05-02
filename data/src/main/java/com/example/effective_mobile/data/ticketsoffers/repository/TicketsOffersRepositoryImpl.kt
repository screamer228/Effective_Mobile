package com.example.effective_mobile.data.ticketsoffers.repository

import android.content.Context
import com.example.effective_mobile.data.datahelper.DataSourceReader.getJsonString
import com.example.effective_mobile.data.ticketsoffers.mapper.TicketsOffersEntityMapper
import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOffersDTO
import com.example.effective_mobile.domain.entity.TicketsOfferEntity
import com.example.effective_mobile.domain.repository.TicketsOffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class TicketsOffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val ticketsOffersEntityMapper: TicketsOffersEntityMapper
) : TicketsOffersRepository {

    override suspend fun getTicketsOffers(): List<TicketsOfferEntity> {
        val gson = Gson()
        val json = getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, TicketsOffersDTO::class.java)
        return ticketsOffersEntityMapper.mapTicketsOffersEntityList(response)
    }
}

private const val FILE_NAME = "tickets_offers.json"