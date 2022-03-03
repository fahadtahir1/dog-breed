package com.arbisoft.dogbreedsearch.domain.repository

import com.arbisoft.dogbreedsearch.data.model.BreedsDto


interface SearchBreedRepository {

    suspend fun searchBreed(query: String): BreedsDto
}