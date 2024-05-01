package com.example.effective_mobile.data.ticketsoffers.repository

import android.content.Context
import com.example.effective_mobile.data.DataSourceReader
import com.example.effective_mobile.data.ticketsoffers.model.dto.TicketsOffersDTO
import com.example.effective_mobile.data.ticketsoffers.mapper.TicketsOffersDtoMapper
import com.example.effective_mobile.data.ticketsoffers.model.response.TicketsOffersResponse
import com.example.effective_mobile.domain.repository.TicketsOffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class TicketsOffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val ticketsOffersDtoMapper: TicketsOffersDtoMapper
) : TicketsOffersRepository {

    override suspend fun getTicketsOffers(): TicketsOffersDTO {
        val gson = Gson()
        val json = DataSourceReader.getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, TicketsOffersResponse::class.java)
        return ticketsOffersDtoMapper.mapTicketsOffersDto(response)
    }
}

private const val FILE_NAME = "tickets_offers.json"