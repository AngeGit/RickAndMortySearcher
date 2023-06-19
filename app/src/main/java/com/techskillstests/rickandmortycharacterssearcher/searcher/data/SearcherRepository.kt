package com.techskillstests.rickandmortycharacterssearcher.searcher.data

import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.SearcherClient
import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.SearcherService
import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.response.SearcherDataResponse
import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.response.toCharacterListDomainDataResponse
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData
import javax.inject.Inject

class SearcherRepository @Inject constructor(private val api: SearcherService) {
    suspend fun getCharacters(): List<SearcherUiData>? {
        val characterList: MutableList<SearcherUiData> = mutableListOf()
        api.getCharacters()?.characterInfo?.forEach {
            characterList.add(it.toCharacterListDomainDataResponse())
        }
        return characterList
    }
}
