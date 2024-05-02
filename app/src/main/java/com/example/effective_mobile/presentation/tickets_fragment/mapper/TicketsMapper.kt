package com.example.effective_mobile.presentation.tickets_fragment.mapper

import com.example.effective_mobile.domain.entity.TicketEntity
import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket
import com.example.effective_mobile.utils.StringsUtils.addSpaceEveryThreeDigits
import com.example.effective_mobile.utils.StringsUtils.calculateFlightTime
import com.example.effective_mobile.utils.StringsUtils.convertDateTimeToTime
import com.example.effective_mobile.utils.StringsUtils.stringsToRow

class TicketsMapper {

    fun mapDtoToUiList(entityList: List<TicketEntity>): List<Ticket> {
        return entityList.map {
            mapDtoToUi(it)
        }
    }

    private fun mapDtoToUi(entity: TicketEntity): Ticket {

        val departureTime = convertDateTimeToTime(entity.departureDate)
        val arrivalTime = convertDateTimeToTime(entity.arrivalDate)
        val travelTime = calculateFlightTime(entity.arrivalDate, entity.departureDate)

        return Ticket(
            id = entity.id,
            badge = entity.badge,
            price = addSpaceEveryThreeDigits(entity.price),
            timeRange = stringsToRow(arrivalTime, departureTime, " — "),
            departureAirport = entity.departureAirport,
            arrivalAirport = entity.arrivalAirport,
            travelTime = travelTime,
            hasTransfer = entity.hasTransfer
        )
    }
}