package com.example.effective_mobile.presentation.countryselected_fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.effective_mobile.R
import com.example.effective_mobile.databinding.ItemTicketsOffersBinding
import com.example.effective_mobile.presentation.countryselected_fragment.model.TicketsOffer
import com.example.effective_mobile.utils.TicketsOffersDiffUtil

class TicketsOffersAdapter(private val context: Context) :
    RecyclerView.Adapter<TicketsOffersAdapter.ViewHolder>() {

    private var ticketsOffersList: List<TicketsOffer> = listOf()

    inner class ViewHolder(private val binding: ItemTicketsOffersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TicketsOffer, position: Int) {
            val iconColor = when (position) {
                0 -> {
                    R.color.red
                }

                1 -> {
                    R.color.blue
                }

                else -> {
                    R.color.white
                }
            }
            binding.ticketsOfferIcon.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    iconColor
                )
            )
            binding.ticketsOfferTitle.text = item.title
            binding.ticketsOfferPrice.text = item.price
            binding.ticketsOfferTime.text = item.timeRange
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketsOffersBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ticketsOffersList[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return ticketsOffersList.size
    }

    fun updateList(newDataList: List<TicketsOffer>) {
        val diffUtil = TicketsOffersDiffUtil(ticketsOffersList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        ticketsOffersList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }
}