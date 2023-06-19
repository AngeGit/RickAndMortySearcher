package com.techskillstests.rickandmortycharacterssearcher.searcher.ui.screen.body



import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.techskillstests.rickandmortycharacterssearcher.R
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.SearcherVM
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData


@Composable
fun Body(modifier: Modifier, searcherVM: SearcherVM) {

    val searchText: String by searcherVM.searchText.observeAsState(initial = "")
    SearchTextField(searchText) { searcherVM.onSearchTextChanged(it) }

    if (searcherVM.characterList.value != null) {
        if(searcherVM.characterList.value!!.isNotEmpty()){
            val stickyMap: Map<String, List<SearcherUiData>> =
                searcherVM.characterList.value!!.groupBy { it.name }
            SearcherRecyclerView(stickyMap, searcherVM, modifier)
        }else{
            Toast.makeText(LocalContext.current, stringResource(R.string.no_characters_in_list),Toast.LENGTH_LONG).show()
        }
    }
}
