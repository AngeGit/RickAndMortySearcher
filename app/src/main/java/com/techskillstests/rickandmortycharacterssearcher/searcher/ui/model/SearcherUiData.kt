package com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model

import com.google.gson.annotations.SerializedName

data class SearcherUiData(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("species") val species: String,
    @SerializedName("image") val image: String
)
