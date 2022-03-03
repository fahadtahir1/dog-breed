package com.arbisoft.dogbreedsearch.data.model

import com.arbisoft.dogbreedsearch.domain.model.Breed
import com.arbisoft.dogbreedsearch.domain.model.Height
import com.arbisoft.dogbreedsearch.domain.model.Image
import com.arbisoft.dogbreedsearch.domain.model.Weight

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

fun BreedDto.toDomainBreeds(): Breed {
    return Breed(
        this.bred_for,
        this.breed_group,
        Height(this.height.imperial, this.height.metric),
        this.id,
        Image(this.image.height, this.image.id, this.image.url, this.image.width),
        this.life_span,
        this.name,
        this.origin,
        this.reference_image_id,
        this.temperament,
        Weight(this.weight.imperial, this.weight.metric)
    )
}

fun BreedDto.toDomainBreed(): Breed {
    return Breed(
        bred_for = this.bred_for ?: "",
        breed_group = this.breed_group ?: "",
        height = Height(imperial = this.height.imperial ?: "", metric = this.height.metric ?: ""),
        id = this.id,
        image = Image(
            height = this.image.height,
            width = this.image.width,
            id = this.image.id ?: "",
            url = this.image.url ?: ""
        ),
        life_span = this.life_span ?: "",
        name = this.name ?: "",
        origin = this.origin ?: "",
        reference_image_id = this.reference_image_id ?: "",
        temperament = this.temperament ?: "",
        weight = Weight(imperial = this.weight.imperial ?: "", metric = this.weight.metric ?: "")
    )
}