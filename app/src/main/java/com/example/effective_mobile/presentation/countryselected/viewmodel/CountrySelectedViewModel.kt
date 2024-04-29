package com.example.effective_mobile.presentation.countryselected.viewmodel

import androidx.lifecycle.ViewModel
import com.example.effective_mobile.presentation.main.uistate.MainUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountrySelectedViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()



}