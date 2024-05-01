package com.example.effective_mobile.presentation.tickets_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.effective_mobile.databinding.ItemTicketBinding
import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket
import com.example.effective_mobile.utils.TicketsDiffUtil

class TicketsAdapter : RecyclerView.Adapter<TicketsAdapter.ViewHolder>() {

    private var ticketsList: List<Ticket> = listOf()

    inner class ViewHolder(private val binding: ItemTicketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Ticket) {
            if (item.badge != null) {
                binding.itemBadgeText.text = item.badge
            } else {
                binding.itemBadgeBackground.visibility = View.INVISIBLE
            }
            binding.itemPrice.text = item.price
            binding.itemTimeRange.text = item.timeRange
            binding.itemAirportDeparture.text = item.departureAirport
            binding.itemAirportArrival.text = item.arrivalAirport
            binding.itemTravelTime.text = item.travelTime
            binding.itemWithoutTransfer.isVisible = !item.hasTransfer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ticketsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return ticketsList.size
    }

    fun updateList(newDataList: List<Ticket>) {
        val diffUtil = TicketsDiffUtil(ticketsList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        ticketsList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }
}