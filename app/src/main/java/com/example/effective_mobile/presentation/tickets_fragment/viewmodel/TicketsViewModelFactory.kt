package com.example.effective_mobile.presentation.tickets_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.usecase.getticketsoffers.GetTicketsUseCase
import com.example.effective_mobile.presentation.tickets_fragment.mapper.TicketsMapper

class TicketsViewModelFactory(
    private val getTicketsUseCase: GetTicketsUseCase,
    private val ticketsMapper: TicketsMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TicketsViewModel(
                getTicketsUseCase,
                ticketsMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}