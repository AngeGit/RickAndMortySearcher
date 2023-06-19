package com.techskillstests.rickandmortycharacterssearcher.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techskillstests.rickandmortycharacterssearcher.detail.ui.screen.DetailScreen
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.SearcherVM
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.screen.SearcherScreen

@Composable
fun ScreensNavHost(searcherVM: SearcherVM){
    val navigationController= rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.searcherScreen.route){
        composable(Routes.searcherScreen.route){
            searcherVM.setNavController(navigationController)
            SearcherScreen(searcherVM)
        }
        composable(Routes.detailScreen.route){
            DetailScreen(searcherVM)
        }
    }
}