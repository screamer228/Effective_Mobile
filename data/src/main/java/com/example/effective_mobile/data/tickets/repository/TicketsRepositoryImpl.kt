package com.example.effective_mobile.data.tickets.repository

import android.content.Context
import com.example.effective_mobile.data.DataSourceReader
import com.example.effective_mobile.data.tickets.mapper.TicketsEntityMapper
import com.example.effective_mobile.data.tickets.dto.TicketsDTO
import com.example.effective_mobile.domain.entity.TicketEntity
import com.example.effective_mobile.domain.repository.TicketsRepository
import com.google.gson.Gson
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(
    private val context: Context,
    private val ticketsEntityMapper: TicketsEntityMapper
) : TicketsRepository {

    override suspend fun getTickets(): List<TicketEntity> {
        val gson = Gson()
        val json = DataSourceReader.getJsonString(context, FILE_NAME)
        val response = gson.fromJson(json, TicketsDTO::class.java)
        return ticketsEntityMapper.mapTicketsDto(response)
    }
}

private const val FILE_NAME = "tickets.json"
