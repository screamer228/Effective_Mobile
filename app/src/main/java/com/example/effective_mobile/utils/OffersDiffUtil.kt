package com.example.effective_mobile.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.effective_mobile.presentation.main_fragment.model.Offer

class OffersDiffUtil(
    private val oldList: List<Offer>,
    private val newList: List<Offer>
) : DiffUtil.Callback() {
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
            oldList[oldItemPosition].imageUrl != newList[newItemPosition].imageUrl -> {
                false
            }

            oldList[oldItemPosition].title != newList[newItemPosition].title -> {
                false
            }

            oldList[oldItemPosition].town != newList[newItemPosition].town -> {
                false
            }

            oldList[oldItemPosition].price != newList[newItemPosition].price -> {
                false
            }

            else -> true
        }
    }
}