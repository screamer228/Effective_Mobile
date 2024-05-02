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
import com.example.effective_mobile.domain.mapper.OffersEntityMapper
import com.example.effective_mobile.domain.mapper.TicketsEntityMapper
import com.example.effective_mobile.domain.mapper.TicketsOffersEntityMapper
import com.example.effective_mobile.domain.repository.OffersRepository
import com.example.effective_mobile.domain.repository.SharedPrefsRepository
import com.example.effective_mobile.domain.repository.TicketsOffersRepository
import com.example.effective_mobile.domain.repository.TicketsRepository
import com.example.effective_mobile.domain.usecase.getlastinput.GetLastInputUseCase
import com.example.effective_mobile.domain.usecase.getlastinput.GetLastInputUseCaseImpl
import com.example.effective_mobile.domain.usecase.getoffers.GetOffersUseCase
import com.example.effective_mobile.domain.usecase.getoffers.GetOffersUseCaseImpl
import com.example.effective_mobile.domain.usecase.gettickets.GetTicketsOffersUseCase
import com.example.effective_mobile.domain.usecase.gettickets.GetTicketsOffersUseCaseImpl
import com.example.effective_mobile.domain.usecase.getticketsoffers.GetTicketsUseCase
import com.example.effective_mobile.domain.usecase.getticketsoffers.GetTicketsUseCaseImpl
import com.example.effective_mobile.domain.usecase.saveinput.SaveInputUseCase
import com.example.effective_mobile.domain.usecase.saveinput.SaveInputUseCaseImpl
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
    fun provideGetTicketsUseCase(
        ticketsRepository: TicketsRepository,
    ): GetTicketsUseCase {
        return GetTicketsUseCaseImpl(
            ticketsRepository,
            ticketsEntityMapper = TicketsEntityMapper()
        )
    }

    @Provides
    fun provideGetTicketsOffersUseCase(
        ticketsOffersRepository: TicketsOffersRepository
    ): GetTicketsOffersUseCase {
        return GetTicketsOffersUseCaseImpl(
            ticketsOffersRepository,
            ticketsOffersEntityMapper = TicketsOffersEntityMapper()
        )
    }

    @Provides
    fun provideGetOffersUseCase(
        offersRepository: OffersRepository
    ): GetOffersUseCase {
        return GetOffersUseCaseImpl(
            offersRepository,
            offersEntityMapper = OffersEntityMapper()
        )
    }

    @Provides
    fun provideGetLastInputUseCase(
        sharedPrefsRepository: SharedPrefsRepository
    ): GetLastInputUseCase {
        return GetLastInputUseCaseImpl(
            sharedPrefsRepository
        )
    }

    @Provides
    fun provideSaveInputUseCase(
        sharedPrefsRepository: SharedPrefsRepository
    ): SaveInputUseCase {
        return SaveInputUseCaseImpl(
            sharedPrefsRepository
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