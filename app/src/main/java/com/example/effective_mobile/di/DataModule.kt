package com.example.effective_mobile.di

import android.content.Context
import android.content.SharedPreferences
import com.example.effective_mobile.BuildConfig
import com.example.effective_mobile.data.sharedprefs.SharedPrefsRepositoryImpl
import com.example.effective_mobile.data.offers.mapper.OffersEntityMapper
import com.example.effective_mobile.data.offers.repository.OffersRepositoryImpl
import com.example.effective_mobile.data.tickets.mapper.TicketsEntityMapper
import com.example.effective_mobile.data.tickets.repository.TicketsRepositoryImpl
import com.example.effective_mobile.data.ticketsoffers.mapper.TicketsOffersEntityMapper
import com.example.effective_mobile.data.ticketsoffers.repository.TicketsOffersRepositoryImpl
import com.example.effective_mobile.domain.repository.OffersRepository
import com.example.effective_mobile.domain.repository.SharedPrefsRepository
import com.example.effective_mobile.domain.repository.TicketsOffersRepository
import com.example.effective_mobile.domain.repository.TicketsRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideTicketsRepository(
        context: Context
    ): TicketsRepository {
        return TicketsRepositoryImpl(
            context,
            ticketsEntityMapper = TicketsEntityMapper()
        )
    }

    @Provides
    fun provideTicketsOffersRepository(
        context: Context
    ): TicketsOffersRepository {
        return TicketsOffersRepositoryImpl(
            context,
            ticketsOffersEntityMapper = TicketsOffersEntityMapper()
        )
    }

    @Provides
    fun provideOffersRepository(
        context: Context
    ): OffersRepository {
        return OffersRepositoryImpl(
            context,
            offersEntityMapper = OffersEntityMapper()
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

}