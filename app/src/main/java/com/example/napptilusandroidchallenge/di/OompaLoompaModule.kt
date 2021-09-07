package com.example.napptilusandroidchallenge.di

import com.example.napptilusandroidchallenge.network.NetworkClient
import com.example.napptilusandroidchallenge.network.OompaLoompaApiDataSource
import com.example.napptilusandroidchallenge.network.OompaLoompaApiDataSourceImpl
import com.example.napptilusandroidchallenge.oompaloompadetail.OompaLoompaDetailViewModel
import com.example.napptilusandroidchallenge.oompaloompalist.OompaLoompaListViewModel
import com.example.napptilusandroidchallenge.repository.OompaLoompasRepository
import com.example.napptilusandroidchallenge.repository.OompaLoompasRepositoryImpl
import com.example.napptilusandroidchallenge.usecases.GetOompaLoompaDataUseCase
import com.example.napptilusandroidchallenge.usecases.GetOompaLoompaDetailsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val oompaLoompaModule = module {

    /**ViewModels */

    viewModel { OompaLoompaListViewModel(get()) }
    viewModel { parameters -> OompaLoompaDetailViewModel(get(), get()) }

    /** Use Cases */
    single { GetOompaLoompaDataUseCase(get()) }
    single { GetOompaLoompaDetailsUseCase(get()) }

    /**Data Sources */
    single<OompaLoompaApiDataSource> {
        OompaLoompaApiDataSourceImpl(
            get()
        )
    }

    /** Repositories */

    single<OompaLoompasRepository> {
        OompaLoompasRepositoryImpl(get())
    }

    single { NetworkClient() }

}
