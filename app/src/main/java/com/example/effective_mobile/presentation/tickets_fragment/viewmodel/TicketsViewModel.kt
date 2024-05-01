package com.example.effective_mobile.presentation.tickets_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effective_mobile.domain.repository.TicketsRepository
import com.example.effective_mobile.presentation.tickets_fragment.mapper.TicketsMapper
import com.example.effective_mobile.presentation.tickets_fragment.uistate.TicketsNavigationEvent
import com.example.effective_mobile.presentation.tickets_fragment.uistate.TicketsUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketsViewModel @Inject constructor(
    private val ticketsRepository: TicketsRepository,
    private val ticketsMapper: TicketsMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(TicketsUiState())
    val uiState: StateFlow<TicketsUiState> = _uiState.asStateFlow()

    init {
        getTickets()
    }

    private fun getTickets() {
        viewModelScope.launch(Dispatchers.IO) {
            val ticketList = ticketsRepository.getTickets()
            val mappedTicketList = ticketsMapper.mapDtoToUiList(ticketList)
            _uiState.value = _uiState.value.copy(ticketsList = mappedTicketList)
        }
    }

    fun setTitles(townsString: String, dateTitle: String) {
        _uiState.value = _uiState.value.copy(townsTitle = townsString)
        _uiState.value = _uiState.value.copy(dateTitle = dateTitle)
    }

    fun setNavigationState(event: TicketsNavigationEvent) {
        _uiState.value = _uiState.value.copy(navigation = event)
    }
}