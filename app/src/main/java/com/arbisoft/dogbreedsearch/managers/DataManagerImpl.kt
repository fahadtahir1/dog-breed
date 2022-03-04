package com.arbisoft.dogbreedsearch.managers


import com.arbisoft.dogbreedsearch.data.remote.BreedAPI
import com.arbisoft.dogbreedsearch.utils.ResourceProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val appService: BreedAPI,
) : DataManager {

    override fun getResourceManager(): ResourceProvider {
        return resourceProvider
    }

    override fun getApiHelper(): BreedAPI {
        return appService
    }

}