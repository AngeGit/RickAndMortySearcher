package com.techskillstests.rickandmortycharacterssearcher.searcher.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.techskillstests.rickandmortycharacterssearcher.core.nav.Routes
import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.response.CharacterInfo
import com.techskillstests.rickandmortycharacterssearcher.searcher.domain.GetCharactersUseCase
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearcherVM @Inject constructor(
    private val getCharacters: GetCharactersUseCase
): ViewModel() {

    private val _navigationController = MutableLiveData<NavHostController>()
    fun setNavController(navController:NavHostController){
        _navigationController.value=navController
    }

    //region SearchBar
    private val _searchText = MutableLiveData<String>("")
    val searchText: LiveData<String> = _searchText
    fun onSearchTextChanged(text: String) {
        _searchText.value = text
        refreshCharacters()
    }
    //endregion SearchBar
    //region Progressbar
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    //endregion Progressbar
    //region RecyclerView
    private val _charactersDefaultList = MutableLiveData<List<SearcherUiData>>()
    private val _characterList = MutableLiveData<List<SearcherUiData>>() //Modifiable list
    val characterList: LiveData<List<SearcherUiData>> = _characterList
    private fun refreshCharacters() {
        _characterList.postValue(_charactersDefaultList.value!!.filter {
            it.name.lowercase().startsWith(_searchText.value!!)
        })
    }
    fun initCharactersList() {
        viewModelScope.launch {
            _isLoading.value = true
            val list: List<SearcherUiData>?= getCharacters()
            if (list != null) {
                _charactersDefaultList.value = list.sortedBy { it.name }//seteamos la lista inicial
                _characterList.value = _charactersDefaultList.value //seteamos la lista para modificar
            }
            _isLoading.value = false
        }
    }

    private val _characterSelected = MutableLiveData<SearcherUiData>()
    val characterSelected: LiveData<SearcherUiData> = _characterSelected

    fun onCharacterClicked(character: SearcherUiData) {
        _characterSelected.value= character
        _navigationController.value!!.navigate(Routes.detailScreen.route)
    }
    //endregion RecyclerView
    fun goBack() {
        _navigationController.value!!.navigate(Routes.searcherScreen.route)
    }


}