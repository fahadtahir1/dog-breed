package com.arbisoft.dogbreedsearch.ui.breeds

import com.arbisoft.dogbreedsearch.models.Breed

data class BreedsState(
    val isLoading: Boolean = false,
    val data: List<Breed>? = null,
    val error: String = ""
)