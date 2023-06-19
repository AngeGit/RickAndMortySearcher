package com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.response

import com.google.gson.annotations.SerializedName
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData

data class SearcherDataResponse(
    @SerializedName("results") val characterInfo: List<CharacterInfo>
)
data class CharacterInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("species") val species: String,
    @SerializedName("image") val image: String
)
//Funciones de extensión para convertir el modelo de datos en el modelo ui:
fun CharacterInfo.toCharacterListDomainDataResponse(): SearcherUiData =
    SearcherUiData(this.id,this.name,this.gender,this.species,this.image)