package com.example.effective_mobile.di

import com.example.effective_mobile.data.ticketsoffers.repository.TicketsOffersRepositoryImpl
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
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetTicketsUseCase(
        ticketsRepository: TicketsRepository,
    ): GetTicketsUseCase {
        return GetTicketsUseCaseImpl(
            ticketsRepository
        )
    }

    @Provides
    fun provideGetTicketsOffersUseCase(
        ticketsOffersRepository: TicketsOffersRepository
    ): GetTicketsOffersUseCase {
        return GetTicketsOffersUseCaseImpl(
            ticketsOffersRepository
        )
    }

    @Provides
    fun provideGetOffersUseCase(
        offersRepository: OffersRepository
    ): GetOffersUseCase {
        return GetOffersUseCaseImpl(
            offersRepository
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

//    @Binds
//    fun bindTicketsOffersRepository(
//        ticketsOffersRepository: TicketsOffersRepositoryImpl
//    ): TicketsOffersRepository

}