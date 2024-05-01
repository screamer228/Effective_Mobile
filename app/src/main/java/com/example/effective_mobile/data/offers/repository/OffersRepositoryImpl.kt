package com.example.effective_mobile.data.offers.repository

import android.content.Context
import com.example.effective_mobile.data.DataSourceReader
import com.example.effective_mobile.data.offers.mapper.OffersDtoMapper
import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.data.offers.model.response.OffersResponse
import com.example.effective_mobile.domain.repository.OffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val offersDtoMapper: OffersDtoMapper
) : OffersRepository {

    override suspend fun getOffers(): OffersDTO {
        val gson = Gson()
        val json = DataSourceReader.getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, OffersResponse::class.java)
        return offersDtoMapper.mapOffersDTO(response)
    }
}

private const val FILE_NAME = "offers.json"