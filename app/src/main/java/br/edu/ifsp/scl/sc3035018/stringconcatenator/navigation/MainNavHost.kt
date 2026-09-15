package br.edu.ifsp.scl.sc3035018.stringconcatenator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.sc3035018.stringconcatenator.ui.composable.HomeScreen

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable (route = Screen.Home.route) { backStackEntry ->
            val newWord = "abacate"
            HomeScreen(
                newWord = newWord,
                modifier = modifier
            )
        }
    }
}