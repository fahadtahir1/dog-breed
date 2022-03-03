package com.arbisoft.dogbreedsearch.domain.repository

import com.arbisoft.dogbreedsearch.data.model.BreedsDto


interface BreedSearchRepository {

    suspend fun searchBreed(query: String): BreedsDto

}