package com.arbisoft.dogbreedsearch.domain.repository

import com.arbisoft.dogbreedsearch.data.model.BreedsDto


interface BreedListRepository {

    suspend fun fetchBreedList() : BreedsDto
}