package com.example.effective_mobile.presentation.main_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effective_mobile.domain.repository.OffersRepository
import com.example.effective_mobile.domain.repository.SharedPrefsRepository
import com.example.effective_mobile.presentation.main_fragment.uistate.MainNavigationEvent
import com.example.effective_mobile.presentation.main_fragment.uistate.MainUiState
import com.example.effective_mobile.presentation.main_fragment.mapper.OffersMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainSharedViewModel @Inject constructor(
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val offersRepository: OffersRepository,
    private val offersMapper: OffersMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        getInputFromPrefs()
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            val offerList = offersRepository.getOffers()
            val mappedOfferList = offersMapper.mapDtoToUiList(offerList)
            _uiState.value = _uiState.value.copy(offersList = mappedOfferList)
        }
    }

    private fun getInputFromPrefs() {
        viewModelScope.launch(Dispatchers.IO) {
            val inputFrom = sharedPrefsRepository.getStringFromPrefs()
            setInputFromInState(inputFrom)
        }
    }

    fun saveInputFromInPrefs() {
        viewModelScope.launch(Dispatchers.IO) {
            sharedPrefsRepository.saveStringInPrefs(uiState.value.inputFrom)
        }
    }

    fun setInputFromInState(inputString: String) {
        _uiState.value = _uiState.value.copy(inputFrom = inputString)
    }

    fun setInputToInState(inputString: String) {
        _uiState.value = _uiState.value.copy(inputTo = inputString)
    }

    fun setNavigationState(event: MainNavigationEvent) {
        _uiState.value = _uiState.value.copy(navigation = event)
    }
}