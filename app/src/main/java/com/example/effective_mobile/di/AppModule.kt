package com.example.effective_mobile.di

import android.content.Context
import android.content.SharedPreferences
import com.example.effective_mobile.BuildConfig
import com.example.effective_mobile.data.SharedPrefsRepositoryImpl
import com.example.effective_mobile.data.offers.mapper.OffersDtoMapper
import com.example.effective_mobile.data.ticketsoffers.mapper.TicketsOffersDtoMapper
import com.example.effective_mobile.data.offers.repository.OffersRepositoryImpl
import com.example.effective_mobile.data.tickets.mapper.TicketsDtoMapper
import com.example.effective_mobile.data.tickets.repository.TicketsRepositoryImpl
import com.example.effective_mobile.data.ticketsoffers.repository.TicketsOffersRepositoryImpl
import com.example.effective_mobile.domain.repository.OffersRepository
import com.example.effective_mobile.domain.repository.SharedPrefsRepository
import com.example.effective_mobile.domain.repository.TicketsOffersRepository
import com.example.effective_mobile.domain.repository.TicketsRepository
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
        ticketsRepository: TicketsRepository
    ): TicketsViewModelFactory {
        return TicketsViewModelFactory(
            ticketsRepository,
            ticketsMapper = TicketsMapper()
        )
    }

    @Provides
    fun provideCountrySelectedViewModelFactory(
        sharedPrefsRepository: SharedPrefsRepository,
        ticketsOffersRepository: TicketsOffersRepository
    ): CountrySelectedViewModelFactory {
        return CountrySelectedViewModelFactory(
            sharedPrefsRepository,
            ticketsOffersRepository,
            ticketsOfferMapper = TicketsOffersMapper()
        )
    }

    @Provides
    fun provideMainSharedViewModelFactory(
        sharedPrefsRepository: SharedPrefsRepository,
        offersRepository: OffersRepository
    ): MainSharedViewModelFactory {
        return MainSharedViewModelFactory(
            sharedPrefsRepository,
            offersRepository,
            offerMapper = OffersMapper()
        )
    }

    @Provides
    fun provideTicketsRepository(
        context: Context
    ): TicketsRepository {
        return TicketsRepositoryImpl(
            context,
            ticketsDtoMapper = TicketsDtoMapper()
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
    fun providesSharedPrefsRepository(
        sharedPreferences: SharedPreferences
    ): SharedPrefsRepository {
        return SharedPrefsRepositoryImpl(sharedPreferences)
    }

    @Provides
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(BuildConfig.PREFS_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideContext(): Context {
        return context
    }
}