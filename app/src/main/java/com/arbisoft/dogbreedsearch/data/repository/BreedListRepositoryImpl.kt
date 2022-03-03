package com.arbisoft.dogbreedsearch.data.repository

import com.arbisoft.dogbreedsearch.data.model.BreedsDto
import com.arbisoft.dogbreedsearch.data.remote.BreedAPI
import com.arbisoft.dogbreedsearch.domain.repository.BreedListRepository

class BreedListRepositoryImpl(private val api: BreedAPI): BreedListRepository {

    override suspend fun fetchBreedList(): BreedsDto {
        return api.fetchBreeds()
    }

}