package com.arbisoft.dogbreedsearch.data.remote

import com.arbisoft.dogbreedsearch.models.Breed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedAPI {

    @GET("breeds")
    suspend fun fetchBreeds() : Response<List<Breed>>


    @GET("breeds/search")
    suspend fun searchBreeds( @Query("q") query: String) : Response<List<Breed>>
}