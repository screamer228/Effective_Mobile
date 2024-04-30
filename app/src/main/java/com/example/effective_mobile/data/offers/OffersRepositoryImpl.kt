package com.example.effective_mobile.data.offers

import android.content.Context
import com.example.effective_mobile.data.DataSourceReader.getJsonString
import com.example.effective_mobile.data.mapper.OffersDtoMapper
import com.example.effective_mobile.data.offers.model.response.OffersResponse
import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.domain.OffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val offersDtoMapper: OffersDtoMapper
) : OffersRepository {

    override suspend fun getOffers(): OffersDTO {
        val gson = Gson()
        val json = getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, OffersResponse::class.java)
        return offersDtoMapper.mapOffersDTO(response)
    }
}

private const val FILE_NAME = "offers.json"