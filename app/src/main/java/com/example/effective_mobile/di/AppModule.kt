package com.example.effective_mobile.di

import android.content.Context
import com.example.effective_mobile.data.mapper.OffersDtoMapper
import com.example.effective_mobile.data.mapper.TicketsOffersDtoMapper
import com.example.effective_mobile.data.offers.OffersRepositoryImpl
import com.example.effective_mobile.data.ticketsoffers.TicketsOffersRepositoryImpl
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.domain.TicketsOffersRepository
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModelFactory
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModelFactory
import com.example.effective_mobile.presentation.mapper.OfferMapper
import com.example.effective_mobile.presentation.mapper.TicketsOfferMapper
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideCountrySelectedViewModelFactory(
        ticketsOffersRepository: TicketsOffersRepository
    ): CountrySelectedViewModelFactory {
        return CountrySelectedViewModelFactory(
            ticketsOffersRepository,
            ticketsOfferMapper = TicketsOfferMapper()
        )
    }

    @Provides
    fun provideMainSharedViewModelFactory(
        offersRepository: OffersRepository
    ): MainSharedViewModelFactory {
        return MainSharedViewModelFactory(
            offersRepository,
            offerMapper = OfferMapper()
        )
    }

    @Provides
    fun provideTicketsOffersRepository(
        context: Context
    ): TicketsOffersRepository {
        return TicketsOffersRepositoryImpl(
            context,
            ticketsOffersDtoMapper = TicketsOffersDtoMapper()
        )
    }

    @Provides
    fun provideOffersRepository(
        context: Context
    ): OffersRepository {
        return OffersRepositoryImpl(
            context,
            offersDtoMapper = OffersDtoMapper()
        )
    }

    @Provides
    fun provideContext() : Context {
        return context
    }
}