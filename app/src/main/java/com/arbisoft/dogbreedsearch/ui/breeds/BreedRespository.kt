package com.arbisoft.dogbreedsearch.ui.breeds

import com.arbisoft.dogbreedsearch.data.remote.BreedAPI
import com.arbisoft.dogbreedsearch.managers.DataManager
import com.arbisoft.dogbreedsearch.models.Breed
import com.arbisoft.dogbreedsearch.utils.Resource
import com.arbisoft.dogbreedsearch.utils.base.BaseRepository
import javax.inject.Inject

class BreedRespository @Inject constructor( dataManager: DataManager) : BaseRepository(dataManager) {


    suspend fun fetchBreeds() : Resource<List<Breed>> {
       return makeApiCall { dataManager.getApiHelper().fetchBreeds() }
    }

    suspend fun searchBreeds(query: String) : Resource<List<Breed>>{
        return makeApiCall { dataManager.getApiHelper().searchBreeds(query) }
    }

}