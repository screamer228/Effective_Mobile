package com.example.effective_mobile.presentation.main_fragment.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.domain.SharedPrefsRepository
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
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val offersRepository: OffersRepository,
    private val offerMapper: OfferMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

//    private val _navigation =
//        MutableStateFlow<MainNavigationEvent>(MainNavigationEvent.NoNavigation)
//    val navigation: StateFlow<MainNavigationEvent> = _navigation.asStateFlow()

    init {
        getInputFromPrefs()
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            val offerList = offersRepository.getOffers()
            val mappedOfferList = offerMapper.mapDtoToUiList(offerList)
            _uiState.value = _uiState.value.copy(offersList = mappedOfferList)
        }
    }

    private fun getInputFromPrefs() {
        viewModelScope.launch(Dispatchers.IO) {
            val inputFrom = sharedPrefsRepository.getStringFromPrefs()
            setInputFromInState(inputFrom)
        }
    }

    fun saveInputInPrefs() {
        viewModelScope.launch(Dispatchers.IO) {
            sharedPrefsRepository.saveStringInPrefs(uiState.value.inputFrom)
        }
    }

    fun setInputFromInState(inputString: String) {
        _uiState.value = _uiState.value.copy(inputFrom = inputString)
    }

    fun setInputToInState(inputString: String) {
        _uiState.value = _uiState.value.copy(inputTo = inputString)
        Log.d("arg check", "setInputInState done -> $inputString")
        Log.d("arg check", "in uiState: ${uiState.value.inputTo}")
    }

    fun navigateToFragmentSearch(event: MainNavigationEvent) {
        setNavigationState(event)
    }

    fun navigateToFragmentCountrySelected(event: MainNavigationEvent) {
        setNavigationState(event)
    }

    fun navigateToFragmentMain(event: MainNavigationEvent) {
        setNavigationState(event)
    }

    private fun setNavigationState(event: MainNavigationEvent) {
        _uiState.value = _uiState.value.copy(navigation = event)
//        _uiState.value = _uiState.value.copy(navigation = event)
    }
}