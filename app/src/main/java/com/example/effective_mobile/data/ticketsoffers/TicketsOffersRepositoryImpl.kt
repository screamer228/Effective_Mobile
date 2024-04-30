package com.example.effective_mobile.data.ticketsoffers

import android.content.Context
import android.util.Log
import com.example.effective_mobile.data.DataSourceReader.getJsonString
import com.example.effective_mobile.data.mapper.TicketsOffersDtoMapper
import com.example.effective_mobile.data.ticketsoffers.dto.TicketsOffersDTO
import com.example.effective_mobile.data.ticketsoffers.response.TicketsOffersResponse
import com.example.effective_mobile.domain.TicketsOffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class TicketsOffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val ticketsOffersDtoMapper: TicketsOffersDtoMapper
) : TicketsOffersRepository {

    override fun getTicketsOffers(): TicketsOffersDTO {
        val gson = Gson()
        val json = getJsonString(context, FILE_NAME)
        Log.d("json check", json)
        val response = gson.fromJson(json, TicketsOffersResponse::class.java)
        Log.d("json check", response.ticketsOffersResponse.first().title)
        return ticketsOffersDtoMapper.mapTicketsOffersDto(response)
    }
}

private const val FILE_NAME = "tickets_offers.json"