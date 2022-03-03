package com.arbisoft.dogbreedsearch.presentation.breeds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arbisoft.dogbreedsearch.core.Resource
import com.arbisoft.dogbreedsearch.domain.usecase.FetchBreedListUseCase
import com.arbisoft.dogbreedsearch.presentation.searchbreed.SearchBreedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(private val useCase: FetchBreedListUseCase) : ViewModel() {


    private val _breedsList = MutableStateFlow<FetchBreedsState>(FetchBreedsState())
    val breedsList: StateFlow<FetchBreedsState> = _breedsList


    fun fetchBreeds() {
        useCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _breedsList.value = FetchBreedsState(isLoading = true)
                }
                is Resource.Success -> {
                    _breedsList.value = FetchBreedsState(data = it.data)
                }
                is Resource.Error -> {
                    _breedsList.value = FetchBreedsState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }




    private val _searchBreedsList = MutableStateFlow<SearchBreedState>(SearchBreedState())
    val searchBreedsList: StateFlow<SearchBreedState> = _searchBreedsList


    fun searchBreeds(query: String) {
        useCase(query).onEach {
            when (it) {
                is Resource.Loading -> {
                    _searchBreedsList.value = SearchBreedState(isLoading = true)
                }
                is Resource.Success -> {
                    _searchBreedsList.value = SearchBreedState(data = it.data)
                }
                is Resource.Error -> {
                    _searchBreedsList.value = SearchBreedState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

}