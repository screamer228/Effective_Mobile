package com.example.effective_mobile.data.tickets.repository

import android.content.Context
import com.example.effective_mobile.data.DataSourceReader
import com.example.effective_mobile.data.tickets.mapper.TicketsDtoMapper
import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO
import com.example.effective_mobile.data.tickets.model.response.TicketsResponse
import com.example.effective_mobile.domain.repository.TicketsRepository
import com.google.gson.Gson
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(
    private val context: Context,
    private val ticketsDtoMapper: TicketsDtoMapper
) : TicketsRepository {

    override suspend fun getTickets(): TicketsDTO {
        val gson = Gson()
        val json = DataSourceReader.getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, TicketsResponse::class.java)
        return ticketsDtoMapper.mapTicketsDto(response)
    }
}

private const val FILE_NAME = "tickets.json"
