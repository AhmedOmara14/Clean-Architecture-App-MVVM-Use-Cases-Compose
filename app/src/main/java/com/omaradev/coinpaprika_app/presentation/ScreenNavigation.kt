package com.omaradev.coinpaprika_app.presentation

sealed class ScreenNavigation(val route :String){
    object CoinListScreen:ScreenNavigation("coin_list_screen")
    object CoinDetailsScreen:ScreenNavigation("coin_details_screen")
}
