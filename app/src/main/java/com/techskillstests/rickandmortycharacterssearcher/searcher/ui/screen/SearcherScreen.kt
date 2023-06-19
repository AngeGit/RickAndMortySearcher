package com.techskillstests.rickandmortycharacterssearcher.searcher.ui.screen

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.techskillstests.rickandmortycharacterssearcher.R
import com.techskillstests.rickandmortycharacterssearcher.common.ui.Header
import com.techskillstests.rickandmortycharacterssearcher.common.ui.LoadingProgressBar
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.SearcherVM
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.screen.body.Body

@Composable
fun SearcherScreen(
    searcherVM: SearcherVM
){
    val isLoading: Boolean by searcherVM.isLoading.observeAsState(initial = false)
    val activity: Activity = LocalContext.current as Activity
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            LoadingProgressBar()
        } else {
            Header(
                stringResource(R.string.header_title),
                Modifier.weight(1f),
                Icons.Default.Close
            ) { activity.finish() }
            if (searcherVM.characterList.value == null) {
                searcherVM.initCharactersList()
            }
            Body(Modifier.weight(1f), searcherVM)
        }
    }
}