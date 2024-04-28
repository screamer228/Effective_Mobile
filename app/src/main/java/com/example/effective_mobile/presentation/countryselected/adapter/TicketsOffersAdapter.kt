package com.example.effective_mobile.presentation.countryselected.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.effective_mobile.R
import com.example.effective_mobile.databinding.ItemTicketsOffersBinding
import com.example.effective_mobile.presentation.model.Offer
import com.example.effective_mobile.utils.MyDiffUtil

class TicketsOffersAdapter() : RecyclerView.Adapter<TicketsOffersAdapter.ViewHolder>() {

    private var offersList: List<Offer> = listOf()

    inner class ViewHolder(private val binding: ItemTicketsOffersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Offer, position: Int) {
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
            binding.ticketsOfferIcon.setCardBackgroundColor(iconColor)
            binding.ticketsOfferTitle.text = item.title
            binding.ticketsOfferPrice.text = item.town
            binding.ticketsOfferTime.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketsOffersBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = offersList[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    fun updateList(newDataList: List<Offer>) {
        val diffUtil = MyDiffUtil(offersList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        offersList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }
}