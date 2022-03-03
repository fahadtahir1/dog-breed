package com.arbisoft.dogbreedsearch.data.repository

import com.arbisoft.dogbreedsearch.data.model.BreedsDto
import com.arbisoft.dogbreedsearch.data.remote.BreedAPI
import com.arbisoft.dogbreedsearch.domain.repository.SearchBreedRepository

class BreedSearchRepositoryImpl(private val api: BreedAPI): SearchBreedRepository {
    override suspend fun searchBreed(query: String): BreedsDto {
        return api.searchBreeds(query = query)
    }
}