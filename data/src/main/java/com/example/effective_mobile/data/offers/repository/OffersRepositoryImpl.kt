package com.example.effective_mobile.data.offers.repository

import android.content.Context
import com.example.effective_mobile.data.DataSourceReader
import com.example.effective_mobile.data.offers.mapper.OffersEntityMapper
import com.example.effective_mobile.data.offers.dto.OffersDTO
import com.example.effective_mobile.domain.entity.OfferEntity
import com.example.effective_mobile.domain.repository.OffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val offersEntityMapper: OffersEntityMapper
) : OffersRepository {

    override suspend fun getOffers(): List<OfferEntity> {
        val gson = Gson()
        val json = DataSourceReader.getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, OffersDTO::class.java)
        return offersEntityMapper.mapOffersEntityList(response)
    }
}

private const val FILE_NAME = "offers.json"