package com.arbisoft.dogbreedsearch.managers

import com.arbisoft.dogbreedsearch.data.remote.BreedAPI
import com.arbisoft.dogbreedsearch.utils.ResourceProvider


interface DataManager {
    fun getApiHelper(): BreedAPI
    fun getResourceManager(): ResourceProvider
}