package com.arbisoft.dogbreedsearch.data.model

import com.arbisoft.dogbreedsearch.domain.model.*

data class BreedDto(
    var bred_for: String,
    var breed_group: String,
    var height: HeightDto,
    var id: Int,
    var image: ImageDto,
    var life_span: String,
    var name: String,
    var origin: String,
    var reference_image_id: String,
    var temperament: String,
    var weight: WeightDto
)

fun BreedDto.toDomainBreed(): Breed {
    return Breed(
        id = this.id,
        name = this.name ?: "",
        url = this.image.url ?: ""
    )
}

fun BreedDto.toDomainBreedDetails(): BreedDetails {
    return BreedDetails(
        bred_for = this.bred_for ?: "",
        breed_group = this.breed_group ?: "",
        height = Height(this.height.imperial, this.height.metric),
        id = this.id,
        image = Image(
            height = this.image.height,
            width = this.image.width,
            id = this.image.id,
            url = this.image.url
        ),
        life_span = this.life_span ?: "",
        name = this.name ?: "",
        origin = this.origin ?: "",
        reference_image_id = this.reference_image_id ?: "",
        temperament = this.temperament ?: "",
        weight = Weight(this.weight.imperial, this.weight.metric)
    )
}