package com.example.effective_mobile.presentation.tickets_fragment.mapper

import com.example.effective_mobile.data.tickets.model.dto.TicketDTO
import com.example.effective_mobile.data.tickets.model.dto.TicketsDTO
import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket
import com.example.effective_mobile.utils.StringsUtils.addSpaceEveryThreeDigits
import com.example.effective_mobile.utils.StringsUtils.calculateFlightTime
import com.example.effective_mobile.utils.StringsUtils.convertDateTimeToTime
import com.example.effective_mobile.utils.StringsUtils.stringsToRow

class TicketsMapper {

    fun mapDtoToUiList(dto: TicketsDTO): List<Ticket> {
        return dto.tickets.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(dto: TicketDTO): Ticket {

        val departureTime = convertDateTimeToTime(dto.departureDate)
        val arrivalTime = convertDateTimeToTime(dto.arrivalDate)
        val travelTime = calculateFlightTime(dto.arrivalDate, dto.departureDate)

        return Ticket(
            id = dto.id,
            badge = dto.badge,
            price = addSpaceEveryThreeDigits(dto.price),
            timeRange = stringsToRow(arrivalTime, departureTime, " — "),
            departureAirport = dto.departureAirport,
            arrivalAirport = dto.arrivalAirport,
            travelTime = travelTime,
            hasTransfer = dto.hasTransfer
        )
    }
}