package com.arbisoft.dogbreedsearch.di

import com.arbisoft.dogbreedsearch.data.remote.BreedAPI
import com.arbisoft.dogbreedsearch.data.repository.BreedListRepositoryImpl
import com.arbisoft.dogbreedsearch.data.repository.BreedSearchRepositoryImpl
import com.arbisoft.dogbreedsearch.domain.repository.BreedListRepository
import com.arbisoft.dogbreedsearch.domain.repository.SearchBreedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideBreedSearchRepository(api: BreedAPI) : SearchBreedRepository{
        return BreedSearchRepositoryImpl(api)
    }

    @Provides
    fun provideBreedListRepository(api: BreedAPI): BreedListRepository {
        return BreedListRepositoryImpl(api)
    }
}