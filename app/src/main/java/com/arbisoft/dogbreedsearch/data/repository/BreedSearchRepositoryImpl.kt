package com.arbisoft.dogbreedsearch.data.repository

import com.arbisoft.dogbreedsearch.data.model.BreedDto
import com.arbisoft.dogbreedsearch.data.model.BreedsDto
import com.arbisoft.dogbreedsearch.data.remote.AppService
import com.arbisoft.dogbreedsearch.domain.repository.SearchBreedRepository

class BreedSearchRepositoryImpl(private val api: AppService): SearchBreedRepository {
    override suspend fun searchBreed(query: String): List<BreedDto> {
        return api.searchBreeds(query = query)
    }
}