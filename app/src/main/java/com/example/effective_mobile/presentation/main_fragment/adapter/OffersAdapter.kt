package com.example.effective_mobile.presentation.main_fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.effective_mobile.R
import com.example.effective_mobile.databinding.ItemOfferBinding
import com.example.effective_mobile.presentation.main_fragment.model.Offer
import com.example.effective_mobile.utils.OffersDiffUtil

class OffersAdapter(private val context: Context) : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {

    private var offersList: List<Offer> = listOf()

    inner class ViewHolder(private val binding: ItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Offer, position: Int) {
            binding.offerImage.load(item.imageUrl)
            binding.offerTitle.text = item.title
            binding.offerTown.text = item.town
            binding.offerPrice.text = context.getString(R.string.from_ps_rubles, item.price)
            if (position == (itemCount - 1)) {
                binding.offerContainer.setPadding(0)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOfferBinding.inflate(inflater, parent, false)
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
        val diffUtil = OffersDiffUtil(offersList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        offersList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }
}