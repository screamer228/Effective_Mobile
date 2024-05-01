package com.example.effective_mobile.presentation.tickets_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.repository.TicketsRepository
import com.example.effective_mobile.presentation.tickets_fragment.mapper.TicketsMapper

class TicketsViewModelFactory(
    private val ticketsRepository: TicketsRepository,
    private val ticketsMapper: TicketsMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketsViewModel::class.java)) {
            return TicketsViewModel(
                ticketsRepository,
                ticketsMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}