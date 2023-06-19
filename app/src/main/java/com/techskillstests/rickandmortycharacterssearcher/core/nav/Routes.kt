package com.techskillstests.rickandmortycharacterssearcher.core.nav

sealed class Routes(val route:String){
    object searcherScreen:Routes(SEARCHER_SCREEN_ROUTE)
    object detailScreen:Routes(DETAIL_SCREEN_ROUTE_ROOT)

    companion object{
        private const val SEARCHER_SCREEN_ROUTE="searcherScreen"
        private const val DETAIL_SCREEN_ROUTE_ROOT="detailScreen"
    }
}

