package com.arbisoft.dogbreedsearch.data.repository

import com.arbisoft.dogbreedsearch.data.model.BreedDto
import com.arbisoft.dogbreedsearch.data.model.BreedsDto
import com.arbisoft.dogbreedsearch.data.remote.AppService
import com.arbisoft.dogbreedsearch.domain.repository.BreedListRepository

class BreedListRepositoryImpl(private val api: AppService): BreedListRepository {
    override suspend fun fetchBreedList(): List<BreedDto> {
        return api.fetchBreeds()

    }


}