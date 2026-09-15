package br.edu.ifsp.scl.sc3035018.stringconcatenator.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc3035018.stringconcatenator.ui.composable.AddWordScreen
import br.edu.ifsp.scl.sc3035018.stringconcatenator.ui.composable.HomeScreen

private const val NEW_WORD = "new_word"
@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable (route = Screen.Home.route) { backStackEntry ->
            val newWord = backStackEntry.savedStateHandle.get<String>(NEW_WORD) ?: ""
            HomeScreen(
                newWord = newWord,
                modifier = modifier,
                onAddWordClick = { currentPhrase ->
                    navHostController.navigate(
                        route = "${Screen.ReceiverAddWord.route}/${Uri.encode(currentPhrase)}"
                    )
                }
            )
        }

        composable (
            route = "${Screen.ReceiverAddWord.route}/{currentPhrase}",
            arguments = listOf(
                navArgument("currentPhrase") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            AddWordScreen(
                currentPhrase = backStackEntry.arguments?.getString("currentPhrase") ?: "",
                modifier = modifier
            ) { newWord ->
                navHostController.previousBackStackEntry?.savedStateHandle?.set(NEW_WORD, newWord)
                navHostController.popBackStack()
            }
        }
    }
}