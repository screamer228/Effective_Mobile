package com.example.effective_mobile.di

import android.content.Context
import com.example.effective_mobile.domain.usecase.getlastinput.GetLastInputUseCase
import com.example.effective_mobile.domain.usecase.getoffers.GetOffersUseCase
import com.example.effective_mobile.domain.usecase.gettickets.GetTicketsOffersUseCase
import com.example.effective_mobile.domain.usecase.getticketsoffers.GetTicketsUseCase
import com.example.effective_mobile.domain.usecase.saveinput.SaveInputUseCase
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModelFactory
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModelFactory
import com.example.effective_mobile.presentation.main_fragment.mapper.OffersMapper
import com.example.effective_mobile.presentation.countryselected_fragment.mapper.TicketsOffersMapper
import com.example.effective_mobile.presentation.tickets_fragment.mapper.TicketsMapper
import com.example.effective_mobile.presentation.tickets_fragment.viewmodel.TicketsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideTicketsViewModelFactory(
        getTicketsUseCase: GetTicketsUseCase
    ): TicketsViewModelFactory {
        return TicketsViewModelFactory(
            getTicketsUseCase,
            ticketsMapper = TicketsMapper()
        )
    }

    @Provides
    fun provideCountrySelectedViewModelFactory(
        getLastInputUseCase: GetLastInputUseCase,
        getTicketsOffersUseCase: GetTicketsOffersUseCase
    ): CountrySelectedViewModelFactory {
        return CountrySelectedViewModelFactory(
            getLastInputUseCase,
            getTicketsOffersUseCase,
            ticketsOfferMapper = TicketsOffersMapper()
        )
    }

    @Provides
    fun provideMainSharedViewModelFactory(
        saveInputUseCase: SaveInputUseCase,
        getLastInputUseCase: GetLastInputUseCase,
        getOffersUseCase: GetOffersUseCase
    ): MainSharedViewModelFactory {
        return MainSharedViewModelFactory(
            saveInputUseCase,
            getLastInputUseCase,
            getOffersUseCase,
            offerMapper = OffersMapper()
        )
    }

    @Provides
    fun provideContext(): Context {
        return context
    }
}