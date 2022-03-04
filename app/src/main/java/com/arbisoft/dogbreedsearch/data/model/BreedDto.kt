package com.arbisoft.dogbreedsearch.data.model

import com.arbisoft.dogbreedsearch.domain.model.Breed
import com.arbisoft.dogbreedsearch.domain.model.Height
import com.arbisoft.dogbreedsearch.domain.model.Image
import com.arbisoft.dogbreedsearch.domain.model.Weight

data class BreedDto(
    var bred_for: String?="",
    var breed_group: String?="",
    var height: HeightDto?=null,
    var id: Int?=0,
    var image: ImageDto?=null,
    var life_span: String?="",
    var name: String?="",
    var origin: String?="",
    var reference_image_id: String?="",
    var temperament: String?="",
    var weight: WeightDto?=null
)

fun BreedDto.toDomainBreeds(): Breed {
    return Breed(
        this.bred_for?:"",
        this.breed_group?:"",
        Height(this.height?.imperial?:"", this.height?.metric?:""),
        this.id?:0,
        Image(this.image?.height?:0, this.image?.id?:"", this.image?.url?:"", this.image?.width?:0),
        this.life_span?:"",
        this.name?:"",
        this.origin?:"",
        this.reference_image_id?:"",
        this.temperament?:"",
        Weight(this.weight?.imperial?:"", this.weight?.metric?:"")
    )
}

