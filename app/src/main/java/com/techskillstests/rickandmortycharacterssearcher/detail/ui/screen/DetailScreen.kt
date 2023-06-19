package com.techskillstests.rickandmortycharacterssearcher.detail.ui.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.techskillstests.rickandmortycharacterssearcher.R
import com.techskillstests.rickandmortycharacterssearcher.common.ui.Header
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.SearcherVM


@Composable
fun DetailScreen(
    vm: SearcherVM
) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            if (vm.characterSelected.value != null) {
                Header(
                    stringResource(R.string.header_title),
                    Modifier.weight(1f),
                    Icons.Default.ArrowBack
                ) { vm.goBack()}
                ItemCharacter(vm.characterSelected.value!!)
            }
        }
}
