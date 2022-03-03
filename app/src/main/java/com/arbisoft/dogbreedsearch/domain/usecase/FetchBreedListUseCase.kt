package com.arbisoft.dogbreedsearch.domain.usecase

import com.arbisoft.dogbreedsearch.core.Resource
import com.arbisoft.dogbreedsearch.data.model.toDomainBreedDetails
import com.arbisoft.dogbreedsearch.domain.model.BreedDetails
import com.arbisoft.dogbreedsearch.domain.repository.BreedListRepository
import com.arbisoft.dogbreedsearch.domain.repository.BreedSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FetchBreedListUseCase @Inject constructor(
    private val breedListRepository: BreedListRepository,
    private val searchBreedRepository: BreedSearchRepository
) {

    operator fun invoke(): Flow<Resource<List<BreedDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = breedListRepository.fetchBreedList()
            val domainData =
                if (!data.breeds.isNullOrEmpty()) data.breeds.map { it -> it.toDomainBreedDetails() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }


    operator fun invoke(query: String): Flow<Resource<List<BreedDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = searchBreedRepository.searchBreed(query)
            val domainData =
                if (!data.breeds.isNullOrEmpty()) data.breeds.map { it -> it.toDomainBreedDetails() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }

}