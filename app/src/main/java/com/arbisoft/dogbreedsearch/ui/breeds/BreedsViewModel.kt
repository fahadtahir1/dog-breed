package com.arbisoft.dogbreedsearch.ui.breeds

import androidx.lifecycle.viewModelScope
import com.arbisoft.dogbreedsearch.utils.Resource
import com.arbisoft.dogbreedsearch.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(
    private val repository: BreedRespository
) : BaseViewModel<BreedNavigator>(repository.dataManager) {


    fun fetchBreeds(){
        viewModelScope.launch {

            repository.fetchBreeds().also {
                when(it){

                    is Resource.Loading -> {
                        getNavigator()?.showProgressBar()
                    }

                    is Resource.Success -> {
                        getNavigator()?.hideProgressBar()

                        it.message
                    }

                    is Resource.Error -> {
                        getNavigator()?.hideProgressBar()
                    }
                }
            }

        }
    }





    fun searchBreeds(query: String){
        viewModelScope.launch {

            repository.searchBreeds(query).also {
                when(it){

                    is Resource.Loading -> {}

                    is Resource.Success -> {}

                    is Resource.Error -> {}
                }
            }

        }
    }


//
//    private val _breedsList = MutableStateFlow<BreedsState>(BreedsState())
//    val breedsList: StateFlow<BreedsState> = _breedsList
//
//
//    fun fetchBreeds() {
//        useCase().onEach {
//            when (it) {
//                is Resource.Loading -> {
//                    _breedsList.value = BreedsState(isLoading = true)
//                }
//                is Resource.Success -> {
//                    _breedsList.value = BreedsState(data = it.data)
//                }
//                is Resource.Error -> {
//                    _breedsList.value = BreedsState(error = it.message ?: "")
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
//
//
//    private val _searchBreedsList = MutableStateFlow<SearchBreedState>(SearchBreedState())
//    val searchBreedsList: StateFlow<SearchBreedState> = _searchBreedsList
//
//
//    fun searchBreeds(query: String) {
//        searchBreedUseCase(query).onEach {
//            when (it) {
//                is Resource.Loading -> {
//                    _searchBreedsList.value = SearchBreedState(isLoading = true)
//                }
//                is Resource.Success -> {
//                    _searchBreedsList.value = SearchBreedState(data = it.data)
//                }
//                is Resource.Error -> {
//                    _searchBreedsList.value = SearchBreedState(error = it.message ?: "")
//                }
//            }
//        }.launchIn(viewModelScope)
//    }

}