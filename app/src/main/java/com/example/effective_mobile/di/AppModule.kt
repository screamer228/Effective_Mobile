package com.example.effective_mobile.di

import com.example.effective_mobile.data.mapper.DtoMapper
import com.example.effective_mobile.data.offers.OffersRepositoryImpl
import com.example.effective_mobile.domain.OffersRepository
import com.example.effective_mobile.presentation.main.viewmodel.MainViewModel
import com.example.effective_mobile.presentation.mapper.OfferMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<OffersRepository> {
        OffersRepositoryImpl(
            context = get(),
            dtoMapper = DtoMapper()
        )
    }

    viewModel<MainViewModel> {
        MainViewModel(
            offersRepository = get(),
            offerMapper = OfferMapper()
        )
    }
}