package com.techskillstests.rickandmortycharacterssearcher.searcher.ui.screen.body

import android.app.Activity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techskillstests.rickandmortycharacterssearcher.R
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.SearcherVM
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearcherRecyclerView(
    characters: Map<String, List<SearcherUiData>>,
    vm: SearcherVM,
    modifier: Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.background(colorResource(id = R.color.recycler_background))
    ) {
        characters.forEach { (name, myList) ->
            stickyHeader {
                Text(
                    text = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.sticky_background),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )
            }

            items(myList) { myList ->
                PaintCharacterItem (
                    character = myList, modifier
                ) {
                    vm.onCharacterClicked(it)
                }
            }
        }
    }
}



