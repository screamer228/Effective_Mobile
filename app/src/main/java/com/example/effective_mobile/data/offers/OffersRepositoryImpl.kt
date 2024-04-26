package com.example.effective_mobile.data.offers

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import com.example.effective_mobile.data.mapper.DtoMapper
import com.example.effective_mobile.data.offers.model.response.OffersResponse
import com.example.effective_mobile.data.offers.model.dto.OffersDTO
import com.example.effective_mobile.domain.OffersRepository
import com.google.gson.Gson
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val context: Context,
    private val dtoMapper: DtoMapper
) : OffersRepository {

    override fun getOffers(): OffersDTO {
        val gson = Gson()
        val json = getJsonString()
        Log.d("viewModel check", "json -> $json")
        val response = gson.fromJson(json, OffersResponse::class.java)
        Log.d("viewModel check", response.offersResponse.first().title)
        return dtoMapper.mapOffersDTO(response)
    }

    private fun getJsonString(): String {
        Log.d("viewModel check", "context -> $context")
        return context.assets.readFile("offers.json")
    }

    private fun AssetManager.readFile(fileName: String) = open(fileName)
        .bufferedReader()
        .use { it.readText() }
}