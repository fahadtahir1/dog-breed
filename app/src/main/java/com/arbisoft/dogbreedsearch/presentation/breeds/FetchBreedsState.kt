package com.arbisoft.dogbreedsearch.presentation.breeds

import com.arbisoft.dogbreedsearch.domain.model.BreedDetails

data class FetchBreedsState(
    val isLoading: Boolean = false,
    val data: List<BreedDetails>? = null,
    val error: String = ""
)