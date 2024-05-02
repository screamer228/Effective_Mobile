package com.example.effective_mobile.data.tickets.dto

import com.google.gson.annotations.SerializedName

data class TicketsDTO(
    @SerializedName("tickets") val ticketsDto: List<TicketDTO>
)