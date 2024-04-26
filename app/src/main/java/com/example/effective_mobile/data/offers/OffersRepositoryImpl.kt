package com.example.effective_mobile.data.offers

import android.content.Context
import android.content.res.AssetManager
import com.example.effective_mobile.data.mapper.DtoMapper
import com.example.effective_mobile.data.offers.model.Offers
import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.domain.OffersRepository
import com.google.gson.Gson

class OffersRepositoryImpl(
    private val context: Context,
    private val dtoMapper: DtoMapper
) : OffersRepository {

    override fun getOffers(): OffersDTO {
        val gson = Gson()
        val json = getJsonString()
        val response = gson.fromJson(json, Offers::class.java)
        return dtoMapper.mapOffersDTO(response)
    }

    private fun getJsonString(): String {
        return context.assets.readFile("offers.json")
    }

    private fun AssetManager.readFile(fileName: String) = open(fileName)
        .bufferedReader()
        .use { it.readText() }
}