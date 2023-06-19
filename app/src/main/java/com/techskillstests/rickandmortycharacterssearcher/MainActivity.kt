package com.techskillstests.rickandmortycharacterssearcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.techskillstests.rickandmortycharacterssearcher.core.nav.ScreensNavHost
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.SearcherVM
import com.techskillstests.rickandmortycharacterssearcher.ui.theme.RickAndMortyCharactersSearcherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val searcherVM: SearcherVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyCharactersSearcherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.dark_teal)
                ) {
                    ScreensNavHost(searcherVM = searcherVM)
                }
            }
        }
    }
}


