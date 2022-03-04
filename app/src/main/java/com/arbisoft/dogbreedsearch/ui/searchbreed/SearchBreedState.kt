package com.arbisoft.dogbreedsearch.presentation.searchbreed

import com.arbisoft.dogbreedsearch.domain.model.Breed

data class SearchBreedState(
    val isLoading: Boolean = false,
    val data: List<Breed>? = null,
    val error: String = ""
)