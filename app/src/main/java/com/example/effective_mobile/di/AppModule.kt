package com.example.effective_mobile.di

import android.content.Context
import android.content.SharedPreferences
import com.example.effective_mobile.BuildConfig
import com.example.effective_mobile.data.SharedPrefsRepositoryImpl
import com.example.effective_mobile.data.mapper.OffersDtoMapper
import com.example.effective_mobile.data.mapper.TicketsOffersDtoMapper
import com.example.effective_mobile.data.offers.OffersRepositoryImpl
import com.example.effective_mobile.data.ticketsoffers.TicketsOffersRepositoryImpl
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.domain.SharedPrefsRepository
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
        sharedPrefsRepository: SharedPrefsRepository,
        ticketsOffersRepository: TicketsOffersRepository
    ): CountrySelectedViewModelFactory {
        return CountrySelectedViewModelFactory(
            sharedPrefsRepository,
            ticketsOffersRepository,
            ticketsOfferMapper = TicketsOfferMapper()
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