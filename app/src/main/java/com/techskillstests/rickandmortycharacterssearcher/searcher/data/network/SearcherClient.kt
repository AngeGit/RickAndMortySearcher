package com.techskillstests.rickandmortycharacterssearcher.searcher.data.network

import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.response.SearcherDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface SearcherClient {
    @GET("character/")
    suspend fun getCharacters(): Response<SearcherDataResponse>
}
