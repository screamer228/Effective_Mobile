package com.example.effective_mobile.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.effective_mobile.databinding.ItemOfferBinding
import com.example.effective_mobile.presentation.main.model.Offer
import com.example.effective_mobile.utils.OffersDiffUtil

class OffersAdapter() : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {

    private var offersList: List<Offer> = listOf()

    inner class ViewHolder(private val binding: ItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Offer) {
            binding.offerImage.load(item.imageUrl)
            binding.offerTitle.text = item.title
            binding.offerTown.text = item.town
            binding.offerPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOfferBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = offersList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    fun updateList(newDataList: List<Offer>) {
        val diffUtil = OffersDiffUtil(offersList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        offersList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }
}