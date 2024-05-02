package com.example.effective_mobile.presentation.main_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.effective_mobile.domain.usecase.getlastinput.GetLastInputUseCase
import com.example.effective_mobile.domain.usecase.getoffers.GetOffersUseCase
import com.example.effective_mobile.domain.usecase.saveinput.SaveInputUseCase
import com.example.effective_mobile.presentation.main_fragment.mapper.OffersMapper

class MainSharedViewModelFactory(
    private val saveInputUseCase: SaveInputUseCase,
    private val getLastInputUseCase: GetLastInputUseCase,
    private val getOffersUseCase: GetOffersUseCase,
    private val offerMapper: OffersMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainSharedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainSharedViewModel(
                saveInputUseCase,
                getLastInputUseCase,
                getOffersUseCase,
                offerMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}