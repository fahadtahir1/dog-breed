package com.arbisoft.dogbreedsearch.presentation.searchbreed

import com.arbisoft.dogbreedsearch.domain.model.BreedDetails

data class SearchBreedState(
    val isLoading: Boolean = false,
    val data: List<BreedDetails>? = null,
    val error: String = ""
)