package com.techskillstests.rickandmortycharacterssearcher.searcher.domain

import com.techskillstests.rickandmortycharacterssearcher.searcher.data.SearcherRepository
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: SearcherRepository) {
    suspend operator fun invoke(): List<SearcherUiData>? {
        return repository.getCharacters()
    }
}