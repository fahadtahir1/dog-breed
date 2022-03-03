package com.arbisoft.dogbreedsearch.data.remote

import com.arbisoft.dogbreedsearch.data.model.BreedDto
import com.arbisoft.dogbreedsearch.data.model.BreedsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedAPI {

    @GET("breeds")
    suspend fun fetchBreeds() : BreedsDto


    @GET("breeds/search")
    suspend fun searchBreeds( @Query("q") query: String) : BreedsDto
}