package com.example.effective_mobile.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket

class TicketsDiffUtil(
    private val oldList: List<Ticket>,
    private val newList: List<Ticket>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }

            oldList[oldItemPosition].badge != newList[newItemPosition].badge -> {
                false
            }

            oldList[oldItemPosition].price != newList[newItemPosition].price -> {
                false
            }

            oldList[oldItemPosition].timeRange != newList[newItemPosition].timeRange -> {
                false
            }

            oldList[oldItemPosition].departureAirport != newList[newItemPosition].departureAirport -> {
                false
            }

            oldList[oldItemPosition].arrivalAirport != newList[newItemPosition].arrivalAirport -> {
                false
            }

            oldList[oldItemPosition].travelTime != newList[newItemPosition].travelTime -> {
                false
            }

            oldList[oldItemPosition].hasTransfer != newList[newItemPosition].hasTransfer -> {
                false
            }

            else -> true
        }
    }
}