package com.arbisoft.dogbreedsearch.presentation.breeds

import com.arbisoft.dogbreedsearch.domain.model.Breed

data class BreedsState(
    val isLoading: Boolean = false,
    val data: List<Breed>? = null,
    val error: String = ""
)