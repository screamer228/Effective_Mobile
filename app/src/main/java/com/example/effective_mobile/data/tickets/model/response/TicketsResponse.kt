package com.example.effective_mobile.data.tickets.model.response

import com.google.gson.annotations.SerializedName

data class TicketsResponse(
    @SerializedName("tickets") val ticketsResponse: List<TicketResponse>
)