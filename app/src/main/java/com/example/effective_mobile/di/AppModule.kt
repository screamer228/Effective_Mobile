package com.example.effective_mobile.di

import android.content.Context
import com.example.effective_mobile.data.mapper.DtoMapper
import com.example.effective_mobile.data.offers.OffersRepositoryImpl
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.presentation.main.viewmodel.MainViewModelFactory
import com.example.effective_mobile.presentation.mapper.OfferMapper
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideMainViewModelFactory(
        offersRepository: OffersRepository
    ): MainViewModelFactory {
        return MainViewModelFactory(
            offersRepository,
            offerMapper = OfferMapper()
        )
    }

    @Provides
    fun provideOffersRepository(
        context: Context
    ): OffersRepository {
        return OffersRepositoryImpl(
            context,
            dtoMapper = DtoMapper()
        )
    }

    @Provides
    fun provideContext() : Context {
        return context
    }
}