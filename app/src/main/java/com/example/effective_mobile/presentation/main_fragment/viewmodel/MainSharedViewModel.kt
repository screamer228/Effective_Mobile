package com.example.effective_mobile.presentation.main_fragment.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.presentation.main_fragment.uistate.MainNavigationEvent
import com.example.effective_mobile.presentation.main_fragment.uistate.MainUiState
import com.example.effective_mobile.presentation.mapper.OfferMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainSharedViewModel @Inject constructor(
    private val offersRepository: OffersRepository,
    private val offerMapper: OfferMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            val offerList = offersRepository.getOffers()
            val mappedOfferList = offerMapper.mapDtoToUiList(offerList)
            _uiState.value = _uiState.value.copy(offersList = mappedOfferList)
        }
    }

    fun setEditTextFromValue(inputString: String) {
        _uiState.value = _uiState.value.copy(inputFrom = inputString)
        Log.d("sharedViewModel check", "in uiState: ${uiState.value.inputFrom}")
    }

    fun navigateToFragmentMain(event: MainNavigationEvent) {
        _uiState.value = _uiState.value.copy(navigation = event)
    }

    fun navigateToFragmentSearch(event: MainNavigationEvent) {
        _uiState.value = _uiState.value.copy(navigation = event)
    }
}