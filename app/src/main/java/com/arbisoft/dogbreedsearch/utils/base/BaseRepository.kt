package com.arbisoft.dogbreedsearch.utils.base

import com.arbisoft.dogbreedsearch.utils.NetworkUtils
import com.arbisoft.dogbreedsearch.utils.Resource
import com.arbisoft.dogbreedsearch.managers.DataManager
import retrofit2.Response

open class BaseRepository(val dataManager: DataManager) {

    suspend fun <T : Any> makeApiCall(
        apiCall: suspend () -> Response<T>,
    ): Resource<T> {
        return verifySessionAndMakeApiCall(apiCall, false)
    }

    protected open fun isNetworkNotAvailable(): Boolean {
        var isConnected = true
        if (!NetworkUtils.isNetworkConnected(dataManager.getResourceManager().getContext())) {
            isConnected = false
        }
        return !isConnected
    }

    suspend fun <T : Any> verifySessionAndMakeApiCall(
        call: suspend () -> Response<T>,
        verifySession: Boolean = true,
    ): Resource<T> {
        if (isNetworkNotAvailable()) {
            return Resource.Error(
                "N Internet connection"
            )
        }

        return apiOutput(call)

    }

    private suspend fun <T : Any> apiOutput(
        call: suspend () -> Response<T>,
    ): Resource<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            Resource.Success(response.body()!!)
        else {
            Resource.Error(response.message())
        }
    }
}