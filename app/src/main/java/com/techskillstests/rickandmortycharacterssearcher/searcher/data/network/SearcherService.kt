package com.techskillstests.rickandmortycharacterssearcher.searcher.data.network

import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.response.SearcherDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearcherService @Inject constructor(private val searcherClient: SearcherClient) {
    suspend fun getCharacters():SearcherDataResponse?{
        return withContext(Dispatchers.IO){
            val response = searcherClient.getCharacters()
            response.body()
        }
    }
}