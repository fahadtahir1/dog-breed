package com.arbisoft.dogbreedsearch.domain.usecase

import com.arbisoft.dogbreedsearch.core.Resource
import com.arbisoft.dogbreedsearch.data.model.BreedDto
import com.arbisoft.dogbreedsearch.data.model.BreedsDto
import com.arbisoft.dogbreedsearch.data.model.toDomainBreeds
import com.arbisoft.dogbreedsearch.domain.model.Breed
import com.arbisoft.dogbreedsearch.domain.repository.BreedListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BreedListUseCase @Inject constructor(private val breedListRepository: BreedListRepository) {

    operator fun invoke(): Flow<Resource<List<Breed>>> = flow {
        try {
            emit(Resource.Loading())
            val data  = breedListRepository.fetchBreedList()
            val domainData =
                 if (data.isNullOrEmpty().not())
                     data?.map { it -> it.toDomainBreeds() }
                 else
                     emptyList()
            emit(Resource.Success(data = domainData!!))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        }
    }

}