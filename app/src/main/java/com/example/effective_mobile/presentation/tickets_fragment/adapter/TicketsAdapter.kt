package com.example.effective_mobile.presentation.tickets_fragment.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.effective_mobile.R
import com.example.effective_mobile.databinding.ItemTicketBinding
import com.example.effective_mobile.presentation.tickets_fragment.model.Ticket
import com.example.effective_mobile.utils.TicketsDiffUtil

class TicketsAdapter(private val context: Context) :
    RecyclerView.Adapter<TicketsAdapter.ViewHolder>() {

    private var ticketsList: List<Ticket> = listOf()

    inner class ViewHolder(private val binding: ItemTicketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Ticket) {
            if (item.badge != null) {
                binding.ticketBadgeText.text = item.badge
            } else binding.ticketBadgeBackground.visibility = View.INVISIBLE
            binding.ticketPrice.text = context.getString(R.string.ps_rubles, item.price)
            binding.ticketTimeRange.text = item.timeRange
            binding.ticketAirportDeparture.text = item.departureAirport
            binding.ticketAirportArrival.text = item.arrivalAirport
            binding.ticketTravelTime.text = context.getString(R.string.ps_on_the_way, item.travelTime)
            binding.ticketWithoutTransfer.isVisible = !item.hasTransfer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ticketsList[position]
        Log.d("transfer check", "in adapter: ${ticketsList.first().hasTransfer}")
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