package com.omaradev.coinpaprika_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omaradev.coinpaprika_app.presentation.note_details.CoinDetailScreen
import com.omaradev.coinpaprika_app.presentation.note_list.CoinListScreen
import com.omaradev.coinpaprika_app.ui.theme.CoinpaprikaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinpaprikaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                   val navController= rememberNavController()
                    NavHost(navController = navController, startDestination =ScreenNavigation.CoinListScreen.route ){
                        composable(route=ScreenNavigation.CoinListScreen.route){
                            CoinListScreen(navController)
                        }
                        composable(route=ScreenNavigation.CoinDetailsScreen.route+"/{coinId}"){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
