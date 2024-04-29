package com.example.effective_mobile.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.effective_mobile.presentation.countryselected.model.TicketsOffer

class TicketsOffersDiffUtil(
    private val oldList: List<TicketsOffer>,
    private val newList: List<TicketsOffer>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
//            oldList[oldItemPosition].iconColor != newList[newItemPosition].iconColor -> {
//                false
//            }
            oldList[oldItemPosition].title != newList[newItemPosition].title -> {
                false
            }
            oldList[oldItemPosition].price != newList[newItemPosition].price -> {
                false
            }
            oldList[oldItemPosition].timeRange != newList[newItemPosition].timeRange -> {
                false
            }
            else -> true
        }
    }
}